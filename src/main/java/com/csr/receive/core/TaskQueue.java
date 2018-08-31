package com.csr.receive.core;

/**
 * User: cdp
 * Date: 2018/7/4
 * Time: 14:29
 */
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class TaskQueue<T> {
    public static Logger LOG = LoggerFactory.getLogger(TaskQueue.class);
    private ExecutorService executorService;
    private final LinkedBlockingQueue<T> queue = new LinkedBlockingQueue<T>();
    public static int size = 1000000;
    private int taskQueueCount = 1;
    private volatile AtomicBoolean run = new AtomicBoolean(false);
    private String queueName = null;
    private int sleepSecond = 0;

    protected TaskQueue() {
    }

    protected TaskQueue(int size, String queueName) {
        size = size;
        this.queueName = queueName;
    }

    protected TaskQueue(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public String getName() {
        return this.queueName;
    }

    protected void setName(String queueName) {
        this.queueName = queueName;
    }

    public boolean isRunnig() {
        return this.run.get();
    }

    public int getSleepSecond() {
        return this.sleepSecond;
    }

    public void setSleepSecond(int sleepSecond) {
        this.sleepSecond = sleepSecond;
    }

    public int size() {
        return this.queue.size();
    }

    public synchronized void start(boolean isStartTask) {
        if (!this.isRunnig()) {
            this.run.set(true);
            if (isStartTask) {
                int i;
                Thread t;
                if (this.executorService == null) {
                    for(i = 1; i <= this.taskQueueCount; ++i) {
                        t = new Thread(new TaskQueue.ProcessThread());
                        t.setDaemon(true);
                        t.start();
                    }
                } else {
                    for(i = 1; i <= this.taskQueueCount; ++i) {
                        t = new Thread(new TaskQueue.ProcessThread());
                        t.setDaemon(true);
                        this.executorService.execute(t);
                    }
                }
            }

        }
    }

    public synchronized void start() {
        this.start(true);
    }

    public void stop() {
        this.queue.clear();
        this.run.set(false);
    }

    public void put(T t) {
        try {
            if (!this.isRunnig()) {
                throw new Exception("QUEUE-" + this.queueName + " not started!");
            }

            if (this.queue.size() >= size - 1) {
                LOG.info("QUEUE-" + this.queueName + " size: " + this.queue.size() + " full!");
                return;
            }

            this.queue.put(t);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public void put(List<T> ts) {
        try {
            if (!this.run.get()) {
                throw new Exception("QUEUE-" + this.queueName + " not started!");
            }

            Iterator it = ts.iterator();

            while(it.hasNext()) {
                T t = (T) it.next();
                this.queue.put(t);
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    protected abstract int doTask(Object var1);

    private class ProcessThread implements Runnable {
        private ProcessThread() {
        }

        public void run() {
            while(TaskQueue.this.run.get()) {
                Object t = null;

                try {
                    t = TaskQueue.this.queue.poll(10L, TimeUnit.SECONDS);
                } catch (Exception var5) {
                    TaskQueue.LOG.error("QUEUE-" + TaskQueue.this.queueName + " processThread:" + var5.getMessage(), var5);
                }

                if (t != null) {
                    try {
                        TaskQueue.this.doTask(t);
                    } catch (Exception var4) {
                        TaskQueue.LOG.error("QUEUE-" + TaskQueue.this.queueName + " processThread:" + var4.getMessage(), var4);
                    }

                    if (TaskQueue.this.sleepSecond > 0) {
                        try {
                            TimeUnit.SECONDS.sleep((long)TaskQueue.this.sleepSecond);
                        } catch (Exception var3) {
                            TaskQueue.LOG.error("QUEUE-" + TaskQueue.this.queueName + " processThread:" + var3.getMessage());
                        }
                    }
                }
            }

            TaskQueue.LOG.info("QUEUE-" + TaskQueue.this.queueName + " processThread quit!");
        }
    }
}
