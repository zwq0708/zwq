package com.example.p7.factory2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool implements ThreadPoolInterface {

    private final ExecutorService executorService;

    public FixedThreadPool(){
        executorService = Executors.newFixedThreadPool(3);

    }

    @Override
    public void executeTask(Runnable runnable) {
        if(executorService==null){
            return;
        }
        executorService.execute(runnable);
    }

    @Override
    public void removeTask(Runnable runnable) {
        if(executorService==null){
            return;
        }
        executorService.shutdown();
    }
}
