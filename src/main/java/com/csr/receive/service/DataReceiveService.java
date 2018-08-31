package com.csr.receive.service;

import com.csr.receive.comm.GlobalParam;
import com.csr.receive.core.BaseServer;
import com.csr.receive.service.nettyudp.Udpnetty.UdpNettyServer;

/**
 * User: cdp
 * Date: 2018/7/9
 * Time: 15:27
 */
public class DataReceiveService extends BaseServer{
    @Override
    public void startServer() {
        UdpNettyServer udpChatServer = new UdpNettyServer(GlobalParam.upd_port);
        try {
            udpChatServer.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void serverHandle() {

    }
}
