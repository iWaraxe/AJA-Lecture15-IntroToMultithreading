// File: Ex04ThreadBasics.java
// Package: com.coherentsolutions.advanced.java.section01

package com.coherentsolutions.advanced.java.section01;

/**
 * This class demonstrates how to create a basic thread in Java using the Thread class.
 * It shows how to define a thread by extending the Thread class and running it.
 */
public class Ex04ThreadBasics extends Thread {

    @Override
    public void run() {
        System.out.println("Thread is running: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        // Create and start a new thread
        Ex04ThreadBasics thread = new Ex04ThreadBasics();
        thread.start(); // This starts the thread and runs the run() method in a separate thread
    }
}
