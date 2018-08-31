package com.csr.receive.service.nettyudp.Udpnetty;


import com.csr.receive.comm.GlobalParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

/*
 * 客户端
 */
public class UDPClient {
    private static Logger LOG = LoggerFactory.getLogger(UDPClient.class);

    public static void main(String[] args) throws IOException {


        while (true) {
            try {
                sendDate();
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private static void sendDate() throws Exception {
        InetAddress address = InetAddress.getByName("localhost");
        int port = GlobalParam.upd_port;
        byte[] data = "用户名：admin;密码：123".getBytes();
        //2.创建数据报，包含发送的数据信息
        DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
        //3.创建DatagramSocket对象
        DatagramSocket socket = new DatagramSocket();
        //4.向服务器端发送数据报
        socket.send(packet);

		/*
         * 接收服务器端响应的数据
		 */
        //1.创建数据报，用于接收服务器端响应的数据
        byte[] data2 = new byte[1024];
        DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
        //2.接收服务器响应的数据
        socket.receive(packet2);
        //3.读取数据
        String reply = new String(data2, 0, packet2.getLength());
        LOG.info("我是客户端，服务器说：" + reply);
        //4.关闭资源
        socket.close();
    }
}