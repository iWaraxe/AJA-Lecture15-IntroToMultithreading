// File: Ex03ImplementingRunnable.java
// Package: com.coherentsolutions.advanced.java.section01

package com.coherentsolutions.advanced.java.section02;

/**
 * This class demonstrates how to create a thread by implementing the Runnable interface.
 * It shows a more flexible way to define thread tasks separately from thread execution.
 */
public class Ex03ImplementingRunnable implements Runnable {

    @Override
    public void run() {
        // Code to be executed by the thread
        System.out.println("Runnable thread is running: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        // Create a Runnable instance
        Ex03ImplementingRunnable runnableTask = new Ex03ImplementingRunnable();

        // Pass the Runnable instance to a new Thread
        Thread thread = new Thread(runnableTask);
        thread.start(); // Start the thread
    }
}
