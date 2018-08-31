package com.csr.receive.service.nettyudp.Udpnetty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: cdp
 * Date: 2018/7/9
 * Time: 10:52
 */
public class ChineseProverClientHandler extends
        SimpleChannelInboundHandler<DatagramPacket> {
    private static Logger LOG= LoggerFactory.getLogger(ChineseProverClientHandler.class);
    /**
     * DatagramPacket的详细介绍，看服务器的代码注释，这里不重复了。
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg)
            throws Exception {
        String response = msg.content().toString(CharsetUtil.UTF_8);
        LOG.info("receive for server "+response);
            ctx.close();

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}