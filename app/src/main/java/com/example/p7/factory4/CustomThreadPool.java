package com.example.p7.factory4;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 对外提供自定义线程池对象：场景：耗时操作
 */
public class CustomThreadPool extends IThreadPool {

    private static CustomThreadPool threadPool;
    private final ThreadPoolExecutor threadExecutor;


    private CustomThreadPool() {
        threadExecutor = new ThreadPoolExecutor(5, 30, 30, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(),
                Executors.defaultThreadFactory());
    }

    public synchronized static CustomThreadPool getCustomThreadPool() {
        if (threadPool == null) {

            synchronized (CustomThreadPool.class) {

                if (threadPool == null) {
                    threadPool = new CustomThreadPool();
                }

            }
        }
        return threadPool;
    }

    public void executeTask(Runnable runnable){
        if(threadExecutor!=null){
            threadExecutor.execute(runnable);
        }
    }

    @Override
    public void removeTask() {

    }


    @Override
    public void removeTask(Runnable runnable) {
        if(threadExecutor!=null){
            threadExecutor.remove(runnable);
        }
    }
}
