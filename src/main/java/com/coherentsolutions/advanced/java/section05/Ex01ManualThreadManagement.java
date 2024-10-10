// File: Ex01ManualThreadManagement.java
// Package: com.coherentsolutions.advanced.java.section05

package com.coherentsolutions.advanced.java.section05;

/**
 * This class demonstrates the overhead of manually managing threads.
 * We manually create a thread for each task, which is not efficient when dealing with many tasks.
 */
public class Ex01ManualThreadManagement {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Task(i)).start(); // Creating a new thread for each task
        }
    }

    static class Task implements Runnable {
        private final int taskId;

        public Task(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            System.out.println("Executing task with ID: " + taskId + " in thread: " + Thread.currentThread().getName());
        }
    }
}
