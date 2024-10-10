// File: Ex01WaitNotifyMechanism.java
// Package: com.coherentsolutions.advanced.java.section04

package com.coherentsolutions.advanced.java.section04;

/**
 * This class demonstrates the basic use of wait() and notify().
 * One thread waits for another thread to send a notification.
 */
public class Ex01WaitNotifyMechanism {

    private static final Object lock = new Object();
    private static boolean condition = false;

    public static void main(String[] args) throws InterruptedException {
        Thread waitingThread = new Thread(() -> {
            synchronized (lock) {
                while (!condition) {
                    try {
                        System.out.println("Waiting thread is waiting for condition...");
                        lock.wait(); // Wait for notification
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Condition met, waiting thread resumed.");
            }
        });

        Thread notifyingThread = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Notifying thread is changing condition and notifying...");
                condition = true;
                lock.notify(); // Notify waiting thread
            }
        });

        waitingThread.start();
        Thread.sleep(1000); // Ensure waitingThread has started waiting
        notifyingThread.start();

        waitingThread.join();
        notifyingThread.join();
    }
}
