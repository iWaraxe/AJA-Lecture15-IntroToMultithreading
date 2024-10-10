// File: Ex02MultithreadedExample.java
// Package: com.coherentsolutions.advanced.java.section01

package com.coherentsolutions.advanced.java.section01;

/**
 * This class demonstrates a multithreaded program where tasks are executed concurrently.
 * It simulates two tasks, each running in a separate thread, allowing them to execute at the same time.
 */
public class Ex02MultithreadedExample {

    public static void main(String[] args) {
        System.out.println("Multithreaded example starting...");

        // Create two threads to run Task 1 and Task 2 concurrently
        Thread task1 = new Thread(() -> doTask1());
        Thread task2 = new Thread(() -> doTask2());

        // Start both threads
        task1.start();
        task2.start();
    }

    /**
     * Simulates a time-consuming operation for Task 1.
     */
    public static void doTask1() {
        System.out.println("Task 1 started...");
        try {
            Thread.sleep(3000); // Simulate task running for 3 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Task 1 finished.");
    }

    /**
     * Simulates a time-consuming operation for Task 2.
     */
    public static void doTask2() {
        System.out.println("Task 2 started...");
        try {
            Thread.sleep(2000); // Simulate task running for 2 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Task 2 finished.");
    }
}
