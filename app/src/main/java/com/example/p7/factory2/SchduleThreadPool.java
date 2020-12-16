package com.example.p7.factory2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchduleThreadPool implements ThreadPoolInterface {


    private final ScheduledExecutorService service;

    public SchduleThreadPool(){
        service = Executors.newSingleThreadScheduledExecutor();
    }

    @Override
    public void executeTask(Runnable runnable) {
        if(service==null){
            return;
        }

        service.scheduleAtFixedRate(runnable,1000,1000, TimeUnit.SECONDS);
    }

    @Override
    public void removeTask(Runnable runnable) {
        if(service==null){
            return;
        }
        service.shutdown();
    }
}
