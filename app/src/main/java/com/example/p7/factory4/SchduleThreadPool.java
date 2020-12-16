package com.example.p7.factory4;

public class SchduleThreadPool extends IThreadPool {

    private static SchduleThreadPool schduleThreadPool;

    

    private SchduleThreadPool(){

    }


    public static synchronized SchduleThreadPool getSchduleThreadPool(){
        if(schduleThreadPool==null){
            synchronized (SchduleThreadPool.class){
                if(schduleThreadPool==null){
                    schduleThreadPool = new SchduleThreadPool();
                }
            }
        }
        return schduleThreadPool;
    }

    @Override
    public void removeTask() {

    }
}
