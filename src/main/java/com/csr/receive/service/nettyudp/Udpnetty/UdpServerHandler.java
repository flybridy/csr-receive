package com.csr.receive.service.nettyudp.Udpnetty;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 消息处理类
 *
 * @author kokJuis
 * @version 1.0
 * @date 2016-9-30
 */
public class UdpServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {
    Logger LOG = LoggerFactory.getLogger(UdpServerHandler.class);

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        //注意，UDP的通道至始至终只有一个，关了就不能接收了。
        LOG.info("[UDP server on connect]");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket
            packet) throws Exception {
        LOG.info("消息来源" + packet.sender().getHostString() + ":" + packet.sender().getPort());
        // 消息处理。。。。。
       // LOG.info("receive data.." + packet.content().toString(CharsetUtil.UTF_8));
       LOG.info("receive data.." + packet.content().toString(CharsetUtil.UTF_8));

        DatagramPacket dp = new DatagramPacket(Unpooled.copiedBuffer("你好。消息已经收到。。".getBytes()), packet.sender());
        UdpNettyServer.channel.writeAndFlush(dp);

    }


}