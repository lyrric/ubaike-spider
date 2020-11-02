package com.github.lyrric.store;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2020-11-02.
 *
 * @author wangxiaodong
 */
public class StoreApplication {

    /** 线程数量 */
    final int CORE_POOL_SIZE = 10;

    private ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 30,
            1, TimeUnit.MINUTES,
            new ArrayBlockingQueue<>(50),
            Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


    public static void main(String[] args) {
        new StoreApplication().start();
    }

    public void start(){
        for (int i = 0; i < CORE_POOL_SIZE; i++) {
            executor.submit(this::run);
        }
        try {
            Thread.currentThread().join() ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void run(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

