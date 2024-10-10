// File: Ex05AtomicVariables.java
// Package: com.coherentsolutions.advanced.java.section03.advanced

package com.coherentsolutions.advanced.java.section03.advanced;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class demonstrates the use of atomic variables to ensure atomicity without using locks.
 */
public class Ex05AtomicVariables {

    private static final AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(Ex05AtomicVariables::incrementCounter);
        Thread thread2 = new Thread(Ex05AtomicVariables::incrementCounter);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final counter value: " + counter.get());
    }

    /**
     * Increment the counter using an AtomicInteger for thread safety.
     */
    private static void incrementCounter() {
        for (int i = 0; i < 1000; i++) {
            counter.incrementAndGet(); // Atomically increment the counter
        }
    }
}
