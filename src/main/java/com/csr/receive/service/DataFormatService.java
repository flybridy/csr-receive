package com.csr.receive.service;

import com.csr.receive.core.BaseServer;

import com.csr.receive.service.task.Task2;

import java.util.concurrent.*;

/**
 * User: cdp
 * Date: 2018/6/29
 * Time: 16:05
 */
public class DataFormatService extends BaseServer {
    public void startServer() {
        ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(2);
      //  scheduledExecutorService.scheduleAtFixedRate(new Task1(),1,3,TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new Task2(),0,4,TimeUnit.SECONDS);

    }

    public void serverHandle() {

    }


}
