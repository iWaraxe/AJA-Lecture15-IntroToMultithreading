// File: Ex01SingleThreadedExample.java
// Package: com.coherentsolutions.advanced.java.section01

package com.coherentsolutions.advanced.java.section01;

/**
 * This class demonstrates a simple single-threaded program where tasks are executed sequentially.
 * It simulates two tasks, each taking a few seconds to complete.
 */
public class Ex01SingleThreadedExample {

    public static void main(String[] args) {
        System.out.println("Single-threaded example starting...");

        // Execute Task 1
        doTask1();

        // Execute Task 2
        doTask2();
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
