package com.csr.receive.service;

import com.csr.receive.core.BaseServer;
import com.csr.receive.service.task.ParseAndSaveDataTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: cdp
 * Date: 2018/6/29
 * Time: 17:01
 */
public class ReceiverService extends BaseServer{
    Logger LOG= LoggerFactory.getLogger(ReceiverService.class);
    public void startServer() {
        try {
            DatagramSocket socket = new DatagramSocket(808);
            ExecutorService thresdpool= Executors.newFixedThreadPool(5);

            while (true){
                byte [] data= new byte[1024];
                DatagramPacket packet=new DatagramPacket(data, data.length);
                socket.receive(packet);
                LOG.info("receive data!!!");
                String messageInfo = new String(packet.getData(), 0, packet.getLength());
                thresdpool.submit(new ParseAndSaveDataTask(messageInfo));
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void serverHandle() {

    }
}
