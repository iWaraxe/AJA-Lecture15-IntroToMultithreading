// File: Ex06AdvancedThreadExample.java
// Package: com.coherentsolutions.advanced.java.section01.advanced

package com.coherentsolutions.advanced.java.section02.advanced;

/**
 * This class extends the previous multithread example by adding a third thread.
 * It demonstrates the unpredictability of thread execution and how threads may interleave.
 */
public class Ex06AdvancedThreadExample {

    public static void main(String[] args) {
        // Create three Runnable tasks
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

        Runnable task3 = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Task 3 - Count: " + i + " running in thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(300); // Pause for 300ms between each iteration
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // Create three threads with the tasks
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        // Start all three threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
