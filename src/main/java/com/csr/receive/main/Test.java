package com.csr.receive.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * User: cdp
 * Date: 2018/7/4
 * Time: 13:22
 */
public class Test {
   static LinkedBlockingQueue<Integer> linkedBlockingQueue=new LinkedBlockingQueue<Integer>(5);
    static Logger logger= LoggerFactory.getLogger(Test.class);
    public static void main(String[] args) {
        logger.info("server start..");
        Thread thread1=new Thread(new Producer());
        thread1.start();

        Thread thread2=new Thread(new Consumer());
        thread2.start();

    }


    static  class Producer implements Runnable{

        public void run() {
            while (true){
                try {
                    linkedBlockingQueue.put(4);
                    logger.info("start put..");
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
   static class Consumer implements Runnable{

        public void run() {
            while (true){
                try {
                   Integer a= linkedBlockingQueue.poll(1,TimeUnit.SECONDS);
                   if (a!=null){
                       logger.info("start poll.."+a);
                   }
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
