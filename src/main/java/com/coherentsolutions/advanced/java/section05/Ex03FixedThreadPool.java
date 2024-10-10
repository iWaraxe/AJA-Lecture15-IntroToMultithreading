// File: Ex03FixedThreadPool.java
// Package: com.coherentsolutions.advanced.java.section05

package com.coherentsolutions.advanced.java.section05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex03FixedThreadPool {

    public static void main(String[] args) {
        // Create a fixed thread pool with 2 threads
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            fixedThreadPool.execute(new Task(i));
        }

        fixedThreadPool.shutdown();
    }

    static class Task implements Runnable {
        private final int taskId;

        public Task(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            System.out.println("Task ID: " + taskId + " running in " + Thread.currentThread().getName());
        }
    }
}
