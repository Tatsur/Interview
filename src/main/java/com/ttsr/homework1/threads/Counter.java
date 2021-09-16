package com.ttsr.homework1.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    public static void main(String[] args) {
        for (int i = 3; i < 10; i++) {
            new Thread(new CounterThread(i)).start();
        }
    }


}
class CounterThread implements Runnable {

    private static int value;

    private static final Lock lock = new ReentrantLock();

    private int incAmount;

    public CounterThread(int incAmount) {
        this.incAmount = incAmount;
    }

    @Override
    public void run() {
        incrementAndGet();
    }

    public void incrementAndGet(){
        lock.lock();
        try {
            for (int i = 0; i < incAmount ; i++) {
                ++value;
                System.out.println(value+" " + Thread.currentThread().getName());
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}