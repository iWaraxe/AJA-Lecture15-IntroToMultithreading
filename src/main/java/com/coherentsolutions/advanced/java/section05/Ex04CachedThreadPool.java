// File: Ex04CachedThreadPool.java
// Package: com.coherentsolutions.advanced.java.section05

package com.coherentsolutions.advanced.java.section05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex04CachedThreadPool {

    public static void main(String[] args) {
        // Create a cached thread pool
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            cachedThreadPool.execute(new Task(i));
        }

        cachedThreadPool.shutdown();
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
