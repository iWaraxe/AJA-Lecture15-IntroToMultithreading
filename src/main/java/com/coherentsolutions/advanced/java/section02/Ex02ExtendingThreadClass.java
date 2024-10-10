// File: Ex02ExtendingThreadClass.java
// Package: com.coherentsolutions.advanced.java.section01

package com.coherentsolutions.advanced.java.section02;

/**
 * This class demonstrates how to create a thread by extending the Thread class.
 * It overrides the run() method to define the task that the thread will execute.
 */
public class Ex02ExtendingThreadClass extends Thread {

    @Override
    public void run() {
        // Code to be executed by the thread
        System.out.println("Thread is running: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        // Create and start a new thread
        Ex02ExtendingThreadClass thread1 = new Ex02ExtendingThreadClass();
        thread1.start(); // This starts the thread and calls the run() method
    }
}
