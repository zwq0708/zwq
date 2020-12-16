package com.example.p7.factory4;

import java.util.concurrent.TimeUnit;

public abstract class IThreadPool {


  public  void executeTask(Runnable runnable){

  }


    public  void executeTimeTask(Runnable runnable, long firstStartTime,
                                 TimeUnit unit,long IntervalTime) {

    }


   public abstract void removeTask();

  public void removeTask(Runnable runnable){

  }
}
