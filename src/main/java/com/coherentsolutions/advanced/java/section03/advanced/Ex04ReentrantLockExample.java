// File: Ex04ReentrantLockExample.java
// Package: com.coherentsolutions.advanced.java.section03.advanced

package com.coherentsolutions.advanced.java.section03.advanced;

import java.util.concurrent.locks.ReentrantLock;

/**
 * This class demonstrates the use of ReentrantLock for fine-grained control over locking.
 */
public class Ex04ReentrantLockExample {

    private static final ReentrantLock lock = new ReentrantLock();
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(Ex04ReentrantLockExample::incrementCounter);
        Thread thread2 = new Thread(Ex04ReentrantLockExample::incrementCounter);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final counter value: " + counter);
    }

    /**
     * Increment the counter using ReentrantLock for thread safety.
     */
    private static void incrementCounter() {
        for (int i = 0; i < 1000; i++) {
            lock.lock(); // Acquire the lock
            try {
                counter++;
            } finally {
                lock.unlock(); // Always release the lock in a finally block
            }
        }
    }
}
