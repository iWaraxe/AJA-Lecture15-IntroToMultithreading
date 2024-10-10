// File: Ex07SubmitVsExecute.java
// Package: com.coherentsolutions.advanced.java.section05

package com.coherentsolutions.advanced.java.section05;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Ex07SubmitVsExecute {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Submit a Runnable task using execute()
        executorService.execute(() -> System.out.println("Executing a Runnable task"));

        // Submit a Callable task using submit() and get the result
        Future<Integer> futureResult = executorService.submit(new Task());

        // Print the result of the Callable task
        System.out.println("Result from Callable task: " + futureResult.get());

        executorService.shutdown();
    }

    static class Task implements Callable<Integer> {
        @Override
        public Integer call() {
            return 42; // Return some result
        }
    }
}

// Summary
// --------------------
// - The Executor framework simplifies thread management by using thread pools, reducing the overhead of creating and destroying threads manually.
// - Different types of thread pools are available depending on your needs: FixedThreadPool, CachedThreadPool, SingleThreadExecutor, and ScheduledThreadPoolExecutor.
// - The submit() method allows for tasks to return results, making it more versatile than execute() for long-running or complex tasks.

// Up Next: We’ll cover the usage of `Callable` tasks and managing the results from multithreaded computations!
