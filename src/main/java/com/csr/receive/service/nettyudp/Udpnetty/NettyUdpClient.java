package com.csr.receive.service.nettyudp.Udpnetty;

import com.csr.receive.comm.GlobalParam;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

public class NettyUdpClient {
    public void run(int port) throws Exception{

        EventLoopGroup group  = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST,true)//允许广播
                    .handler(new ChineseProverClientHandler());//设置消息处理器
            Channel ch = b.bind(0).sync().channel();
            //向网段内的所有机器广播UDP消息。

                ch.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer("谚语字典查询？", CharsetUtil.UTF_8), new InetSocketAddress("255.255.255.255",port))).sync();



        } catch (Exception e) {
            group.shutdownGracefully();
        }
    }
    public static void main(String [] args) throws Exception{
        int port =  GlobalParam.upd_port;;
        NettyUdpClient client=new NettyUdpClient();
        while (true){
          client.run(port);
            TimeUnit.SECONDS.sleep(5);
        }
    }
}
