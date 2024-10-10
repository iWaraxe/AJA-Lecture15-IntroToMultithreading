// File: Ex06VolatileKeyword.java
// Package: com.coherentsolutions.advanced.java.section03.advanced

package com.coherentsolutions.advanced.java.section03.advanced;

/**
 * This class demonstrates the use of the volatile keyword to ensure visibility of changes across threads.
 */
public class Ex06VolatileKeyword {

    private static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            while (running) {
                // Simulate work
                System.out.println("Thread is running...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Thread stopped.");
        });

        worker.start();

        // Let the thread run for a short while
        Thread.sleep(2000);

        // Stop the thread by changing the volatile variable
        running = false;

        worker.join();
    }
}

// Summary
// --------------------
// - Synchronization is essential for ensuring thread safety when accessing shared resources.
// - The synchronized keyword and locks prevent race conditions by ensuring that only one thread can access critical sections at a time.
// - ReentrantLock offers more advanced locking mechanisms, while atomic variables provide lightweight alternatives to locking.
// - The volatile keyword ensures visibility of changes across threads, but does not provide atomicity.

// Up Next: We’ll dive into how to manage thread pools and advanced concurrency utilities!
