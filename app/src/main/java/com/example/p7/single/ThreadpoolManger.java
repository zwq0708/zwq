package com.example.p7.single;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadpoolManger {
    //饿汉式
//    private static ThreadpoolManger mManger = new ThreadpoolManger();
//
//    private ThreadpoolManger(){
//
//    }
//
//    public static ThreadpoolManger getmManger(){
//        return mManger;
//    }

    //懒汉式

    private static ThreadpoolManger mManger;
    private static ThreadpoolManger manger;
    private final ThreadPoolExecutor executor;

    private ThreadpoolManger() {
        executor = new ThreadPoolExecutor(3, 5, 30, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(), Executors.defaultThreadFactory());
    }

    public synchronized static ThreadpoolManger getmManger() {
        if (mManger == null) {

            synchronized (ThreadpoolManger.class) {
                if (mManger == null) {

                    manger = new ThreadpoolManger();

                }

            }

        }

        return mManger;
    }

    public void executeTask(Runnable runnable) {
        if (executor == null)
            return;
        executor.execute(runnable);
    }

    public void remove(Runnable runnable){
        if(executor==null)
            return;
        executor.remove(runnable);
    }
}
