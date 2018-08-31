package com.csr.receive.service.nettyudp.Udpnetty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingQueue;

public class UdpNettyServer {
       private static Logger LOG= LoggerFactory.getLogger(UdpNettyServer.class);

    // UDP服务监听的数据通道
    public static Channel channel;

    // 搞个map保存与客户端地址的映射关系
    public static ConcurrentMap<Integer, NettyUdpClient> userSocketMap = new ConcurrentHashMap<Integer, NettyUdpClient>();

    // 创建一个阻塞队列，用于消息缓冲
    public static BlockingQueue<DatagramPacket> msgQueue = new LinkedBlockingQueue<DatagramPacket>();

    private int port;// 监听端口号

    public UdpNettyServer(int port) {
        this.port = port;
    }

    public void run() throws Exception {

        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();//udp不能使用ServerBootstrap
            b.group(workerGroup).channel(NioDatagramChannel.class)//设置UDP通道
                    .option(ChannelOption.SO_BROADCAST, true)// 支持广播
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .option(ChannelOption.SO_RCVBUF, 1024 * 1024)// 设置UDP读缓冲区为1M
                    .option(ChannelOption.SO_SNDBUF, 1024 * 1024)// 设置UDP写缓冲区为1M
                    .handler(new UdpServerHandler()
                    );
            LOG.info("[UDP server start]");
            // 绑定端口，开始接收进来的连接
            ChannelFuture f = b.bind(port).sync();
            channel = f.channel();
            // 等待服务器 socket 关闭 。
            // 这不会发生，可以优雅地关闭服务器。
            f.channel().closeFuture().await();
        } finally {
            workerGroup.shutdownGracefully();
            LOG.info("[UDP server stop]");
        }
    }

    public static void main(String[] args) {
        UdpNettyServer udpChatServer = new UdpNettyServer(8888);
        try {
            udpChatServer.run();
        } catch (Exception e) {
            LOG.info(e.getMessage(),e);
        }
    }
}