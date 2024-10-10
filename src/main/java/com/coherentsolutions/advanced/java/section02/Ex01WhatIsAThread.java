// File: Ex01WhatIsAThread.java
// Package: com.coherentsolutions.advanced.java.section01

package com.coherentsolutions.advanced.java.section02;

/**
 * This class demonstrates the concept of a single-threaded and multithreaded execution in Java.
 * It will first show a single-threaded example and then a multithreaded example for comparison.
 */
public class Ex01WhatIsAThread {

    public static void main(String[] args) {
        System.out.println("Single-threaded example starting...");
        singleThreadedExecution();

        System.out.println("\nMultithreaded example starting...");
        multithreadedExecution();
    }

    /**
     * Demonstrates single-threaded execution where tasks are run sequentially.
     */
    public static void singleThreadedExecution() {
        doTask1();
        doTask2();
    }

    /**
     * Demonstrates multithreaded execution where tasks are run concurrently using threads.
     */
    public static void multithreadedExecution() {
        Thread task1 = new Thread(() -> doTask1());
        Thread task2 = new Thread(() -> doTask2());

        task1.start();
        task2.start();
    }

    public static void doTask1() {
        System.out.println("Task 1 started...");
        try {
            Thread.sleep(3000); // Simulate time-consuming operation
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Task 1 finished.");
    }

    public static void doTask2() {
        System.out.println("Task 2 started...");
        try {
            Thread.sleep(2000); // Simulate time-consuming operation
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Task 2 finished.");
    }
}
