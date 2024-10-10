// File: Ex03FutureCancellation.java
// Package: com.coherentsolutions.advanced.java.section06

package com.coherentsolutions.advanced.java.section06;

import java.util.concurrent.*;

/**
 * This class demonstrates how to cancel a task using Future's cancel() method.
 */
public class Ex03FutureCancellation {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Submit a long-running task
        Callable<String> task = () -> {
            Thread.sleep(5000); // Simulate long computation
            return "Task Completed!";
        };

        Future<String> future = executorService.submit(task);

        // Try to cancel the task after 2 seconds
        Thread.sleep(2000);
        boolean isCancelled = future.cancel(true); // Cancel the task if it's not done

        if (isCancelled) {
            System.out.println("Task was cancelled.");
        } else {
            System.out.println("Task could not be cancelled.");
        }

        // Check if the task is cancelled
        System.out.println("Is task cancelled? " + future.isCancelled());

        executorService.shutdown();
    }
}
