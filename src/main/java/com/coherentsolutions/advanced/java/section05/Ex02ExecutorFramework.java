// File: Ex02ExecutorFramework.java
// Package: com.coherentsolutions.advanced.java.section05

package com.coherentsolutions.advanced.java.section05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class demonstrates the basic usage of the Executor framework.
 * It uses an ExecutorService to manage the execution of tasks with a fixed thread pool.
 */
public class Ex02ExecutorFramework {

    public static void main(String[] args) {
        // Create a fixed thread pool with 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            executorService.execute(new Task(i)); // Submit tasks for execution
        }

        // Shutdown the executor service after task submission
        executorService.shutdown();
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
