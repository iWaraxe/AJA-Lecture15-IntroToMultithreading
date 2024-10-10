// File: Ex02FutureExample.java
// Package: com.coherentsolutions.advanced.java.section06

package com.coherentsolutions.advanced.java.section06;

import java.util.concurrent.*;

/**
 * This class demonstrates the usage of the Future interface with a Callable task.
 */
public class Ex02FutureExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Create an ExecutorService with a fixed thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Submit a Callable task to the executor service
        Callable<Integer> task = () -> {
            Thread.sleep(2000); // Simulate a long-running task
            return 42;
        };

        Future<Integer> future = executorService.submit(task);

        // Check if the task is done
        System.out.println("Is the task done? " + future.isDone());

        // Retrieve the result (this will block until the task completes)
        Integer result = future.get();
        System.out.println("Result from the Callable task: " + result);

        // Check if the task is done after getting the result
        System.out.println("Is the task done now? " + future.isDone());

        // Shut down the executor service
        executorService.shutdown();
    }
}
