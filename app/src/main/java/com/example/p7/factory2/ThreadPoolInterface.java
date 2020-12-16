package com.example.p7.factory2;

public interface ThreadPoolInterface {

    void executeTask(Runnable runnable);

    void removeTask(Runnable runnable);
}
