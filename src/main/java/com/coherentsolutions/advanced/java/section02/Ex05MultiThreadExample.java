// File: Ex05MultiThreadExample.java
// Package: com.coherentsolutions.advanced.java.section01

package com.coherentsolutions.advanced.java.section02;

/**
 * This class demonstrates creating and running multiple threads concurrently using the Runnable interface.
 * Each thread performs a separate task, and their output interleaves as they run concurrently.
 */
public class Ex05MultiThreadExample {

    public static void main(String[] args) {
        // Create two Runnable tasks
        Runnable task1 = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Task 1 - Count: " + i + " running in thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500); // Pause for 500ms between each iteration
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Runnable task2 = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Task 2 - Count: " + i + " running in thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500); // Pause for 500ms between each iteration
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // Create two threads with the tasks
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        // Start both threads
        thread1.start();
        thread2.start();
    }
}
