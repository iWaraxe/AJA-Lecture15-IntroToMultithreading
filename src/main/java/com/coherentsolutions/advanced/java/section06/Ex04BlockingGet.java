// File: Ex04BlockingGet.java
// Package: com.coherentsolutions.advanced.java.section06

package com.coherentsolutions.advanced.java.section06;

import java.util.concurrent.*;

/**
 * This class demonstrates the blocking nature of the Future.get() method.
 * The main thread is blocked until the task completes.
 */
public class Ex04BlockingGet {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Submit a long-running task
        Callable<String> task = () -> {
            Thread.sleep(3000); // Simulate long computation
            return "Task Completed!";
        };

        Future<String> future = executorService.submit(task);

        System.out.println("Doing other work in the main thread...");

        // Block until the task is complete
        String result = future.get();
        System.out.println("Result from Callable: " + result);

        executorService.shutdown();
    }
}
