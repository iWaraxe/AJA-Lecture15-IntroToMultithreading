// File: Ex02SynchronizedMethod.java
// Package: com.coherentsolutions.advanced.java.section03

package com.coherentsolutions.advanced.java.section03;

/**
 * This class demonstrates the use of the synchronized keyword to fix the race condition.
 * Only one thread can increment the counter at a time.
 */
public class Ex02SynchronizedMethod {

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(Ex02SynchronizedMethod::incrementCounter);
        Thread thread2 = new Thread(Ex02SynchronizedMethod::incrementCounter);

        thread1.start();
        thread2.start();

        // Wait for both threads to finish execution
        thread1.join();
        thread2.join();

        // The final result will always be 2000 as synchronization prevents race conditions.
        System.out.println("Final counter value: " + counter);
    }

    /**
     * Increment counter 1000 times using a synchronized method to ensure thread safety.
     */
    private synchronized static void incrementCounter() {
        for (int i = 0; i < 1000; i++) {
            counter++;
        }
    }
}
