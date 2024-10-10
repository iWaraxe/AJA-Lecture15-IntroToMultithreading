// File: Ex05RunnableBasics.java
// Package: com.coherentsolutions.advanced.java.section01

package com.coherentsolutions.advanced.java.section01;

/**
 * This class demonstrates how to create a basic thread in Java using the Runnable interface.
 * It separates the task definition from the thread execution.
 */
public class Ex05RunnableBasics implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable is running: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        // Create a Runnable instance
        Ex05RunnableBasics runnableTask = new Ex05RunnableBasics();

        // Pass the Runnable instance to a Thread and start it
        Thread thread = new Thread(runnableTask);
        thread.start();
    }
}
