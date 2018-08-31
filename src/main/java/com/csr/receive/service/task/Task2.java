package com.csr.receive.service.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: cdp
 * Date: 2018/6/29
 * Time: 16:23
 */
public class Task2 implements Runnable{
    Logger LOG= LoggerFactory.getLogger(Task2.class);
    public void run() {
            LOG.info("execute Task2");
    }
}
