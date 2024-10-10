// File: Ex01RaceCondition.java
// Package: com.coherentsolutions.advanced.java.section03

package com.coherentsolutions.advanced.java.section03;

/**
 * This class demonstrates a race condition. Multiple threads try to increment a shared counter without synchronization,
 * leading to data inconsistency.
 */
public class Ex01RaceCondition {

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(Ex01RaceCondition::incrementCounter);
        Thread thread2 = new Thread(Ex01RaceCondition::incrementCounter);

        thread1.start();
        thread2.start();

        // Wait for both threads to finish execution
        thread1.join();
        thread2.join();

        // Expected result should be 2000, but it will often be less due to race conditions.
        System.out.println("Final counter value: " + counter);
    }

    /**
     * Increment counter 1000 times.
     */
    private static void incrementCounter() {
        for (int i = 0; i < 1000; i++) {
            counter++;
        }
    }
}
