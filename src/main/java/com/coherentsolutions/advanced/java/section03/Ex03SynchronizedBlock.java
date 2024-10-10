// File: Ex03SynchronizedBlock.java
// Package: com.coherentsolutions.advanced.java.section03

package com.coherentsolutions.advanced.java.section03;

/**
 * This class demonstrates the use of synchronized blocks for more granular control over synchronization.
 * Only the critical section (incrementing the counter) is synchronized.
 */
public class Ex03SynchronizedBlock {

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(Ex03SynchronizedBlock::incrementCounter);
        Thread thread2 = new Thread(Ex03SynchronizedBlock::incrementCounter);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final counter value: " + counter);
    }

    /**
     * Increment counter using a synchronized block instead of synchronizing the entire method.
     */
    private static void incrementCounter() {
        for (int i = 0; i < 1000; i++) {
            synchronized (Ex03SynchronizedBlock.class) {
                counter++;
            }
        }
    }
}
