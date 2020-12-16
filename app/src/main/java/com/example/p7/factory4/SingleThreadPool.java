package com.example.p7.factory4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPool extends IThreadPool {


    private static SingleThreadPool schduleThreadPool;
    private final ExecutorService executorService;


    private SingleThreadPool() {
        executorService = Executors.newSingleThreadExecutor();
    }


    public static synchronized SingleThreadPool getSchduleThreadPool() {
        if (schduleThreadPool == null) {
            synchronized (SingleThreadPool.class){
                if(schduleThreadPool==null){
                 schduleThreadPool = new SingleThreadPool();

                }
            }
        }
        return schduleThreadPool;
    }


    @Override
    public void executeTask(Runnable runnable) {
        if(schduleThreadPool!=null)

        schduleThreadPool.executeTask(runnable );
    }

    @Override
    public void removeTask() {
        executorService.shutdown();
    }
}
