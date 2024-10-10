// File: Ex05SingleThreadExecutor.java
// Package: com.coherentsolutions.advanced.java.section05

package com.coherentsolutions.advanced.java.section05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex05SingleThreadExecutor {

    public static void main(String[] args) {
        // Create a single thread executor
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 5; i++) {
            singleThreadExecutor.execute(new Task(i));
        }

        singleThreadExecutor.shutdown();
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
