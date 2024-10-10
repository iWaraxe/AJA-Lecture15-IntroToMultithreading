// File: Ex06ScheduledThreadPoolExecutor.java
// Package: com.coherentsolutions.advanced.java.section05

package com.coherentsolutions.advanced.java.section05;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Ex06ScheduledThreadPoolExecutor {

    public static void main(String[] args) {
        // Create a scheduled thread pool with 1 thread
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);

        // Schedule a task to run after 2 seconds
        scheduledThreadPool.schedule(new Task(1), 2, TimeUnit.SECONDS);

        // Schedule a task to run periodically every 3 seconds
        scheduledThreadPool.scheduleAtFixedRate(new Task(2), 1, 3, TimeUnit.SECONDS);

        // Allow some time before shutting down
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        scheduledThreadPool.shutdown();
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
