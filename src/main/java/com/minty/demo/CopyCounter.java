package com.minty.demo;

public class CopyCounter extends Thread{

    private static Integer counter = 0;

    public synchronized void incrementCounter() {
        counter++;
    }

    public static synchronized Integer getCounter() {
        return counter;
    }
    @Override
    public synchronized void start() {
        super.start();
    }
    public synchronized boolean isRunnable() {
        return super.isAlive() && !super.isInterrupted();
    }
}
