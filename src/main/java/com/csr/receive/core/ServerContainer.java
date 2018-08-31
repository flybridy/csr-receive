package com.csr.receive.core;

import java.util.ArrayList;

/**
 * User: cdp
 * Date: 2018/6/29
 * Time: 13:41
 */
public class ServerContainer {
    private TaskQueue<BaseServer> servicequeue = new TaskQueue<BaseServer>() {
        @Override
        protected int doTask(Object var1) {
            BaseServer var = (BaseServer) var1;
            var.startServer();
            return 0;
        }
    };

    public void addService(Class<? extends BaseServer> clazz) {
        try {
            BaseServer server = clazz.newInstance();
            servicequeue.put(server);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public void start() {
        servicequeue.start();

    }
    public void stop(){
        servicequeue.stop();
    }
}
