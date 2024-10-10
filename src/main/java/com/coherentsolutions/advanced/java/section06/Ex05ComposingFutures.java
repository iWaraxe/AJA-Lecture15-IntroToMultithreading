// File: Ex05ComposingFutures.java
// Package: com.coherentsolutions.advanced.java.section06

package com.coherentsolutions.advanced.java.section06;

import java.util.concurrent.*;

/**
 * This class demonstrates the difficulty of composing multiple Future tasks.
 * We have to manually manage the dependency between tasks.
 */
public class Ex05ComposingFutures {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Task 1: Simulate a task that takes 2 seconds to complete
        Callable<String> task1 = () -> {
            Thread.sleep(2000);
            return "Result from Task 1";
        };

        // Task 2: Simulate a task that depends on the result of Task 1
        Callable<String> task2 = () -> {
            Thread.sleep(1000);
            return "Result from Task 2";
        };

        // Submit Task 1
        Future<String> future1 = executorService.submit(task1);

        // Wait for Task 1 to finish and then submit Task 2
        String result1 = future1.get(); // Blocking wait
        System.out.println(result1);

        Future<String> future2 = executorService.submit(task2);
        String result2 = future2.get(); // Blocking wait
        System.out.println(result2);

        executorService.shutdown();
    }
}

// Summary
// --------------------
// - The `Callable` interface allows tasks to return results and throw exceptions, making it more flexible than `Runnable`.
// - The `Future` interface is used to represent the result of an asynchronous computation, providing methods like `get()`, `isDone()`, and `cancel()`.
// - While useful, `Future` has limitations, such as the blocking nature of `get()` and difficulty in composing multiple futures.

// Up Next: We will dive into `CompletableFuture`, which addresses many of these limitations and provides powerful features for working with asynchronous tasks!
