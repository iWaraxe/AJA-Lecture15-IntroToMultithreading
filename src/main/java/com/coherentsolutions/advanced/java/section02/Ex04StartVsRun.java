// File: Ex04StartVsRun.java
// Package: com.coherentsolutions.advanced.java.section01

package com.coherentsolutions.advanced.java.section02;

/**
 * This class demonstrates the difference between the start() and run() methods in threading.
 * It shows how calling run() directly does not start a new thread, but calling start() does.
 */
public class Ex04StartVsRun {

    public static void main(String[] args) {
        // Create a Runnable task
        Runnable task = () -> System.out.println("Running in thread: " + Thread.currentThread().getName());

        // Create a thread with the Runnable task
        Thread thread = new Thread(task);

        // Calling run() method directly (no new thread is started)
        System.out.println("Calling run() method directly...");
        thread.run(); // This will run on the main thread

        // Calling start() method to create and run a new thread
        System.out.println("Calling start() method...");
        thread.start(); // This will run on a separate thread
    }
}
