// File: Ex03WhyMultithreading.java
// Package: com.coherentsolutions.advanced.java.section01

package com.coherentsolutions.advanced.java.section01;

/**
 * This class demonstrates the importance of multithreading in Java.
 * It shows how single-threaded execution can block other tasks, and how multithreading can solve this problem.
 */
public class Ex03WhyMultithreading {

    public static void main(String[] args) {
        // Simulate a real-world scenario where multiple tasks need to be executed concurrently.

        // Single-threaded example
        System.out.println("Single-threaded example starting...");
        singleThreadedExecution();

        // Multithreaded example
        System.out.println("\nMultithreaded example starting...");
        multithreadedExecution();
    }

    /**
     * Simulates a sequential execution of tasks in a single-threaded manner.
     */
    public static void singleThreadedExecution() {
        doTask1();
        doTask2();
    }

    /**
     * Simulates concurrent execution of tasks in a multithreaded manner.
     */
    public static void multithreadedExecution() {
        Thread thread1 = new Thread(() -> doTask1());
        Thread thread2 = new Thread(() -> doTask2());

        thread1.start();
        thread2.start();
    }

    public static void doTask1() {
        System.out.println("Task 1 started...");
        try {
            Thread.sleep(3000); // Simulate task running for 3 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Task 1 finished.");
    }

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
