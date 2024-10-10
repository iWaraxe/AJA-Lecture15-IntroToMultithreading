// File: Ex01RunnableVsCallable.java
// Package: com.coherentsolutions.advanced.java.section06

package com.coherentsolutions.advanced.java.section06;

import java.util.concurrent.Callable;

/**
 * This class demonstrates the difference between Runnable and Callable interfaces.
 */
public class Ex01RunnableVsCallable {

    public static void main(String[] args) throws Exception {
        // Using a Runnable (no result or exception)
        Runnable runnableTask = () -> System.out.println("Runnable task executed");

        // Using a Callable (returns a result and can throw an exception)
        Callable<Integer> callableTask = () -> {
            System.out.println("Callable task executed");
            return 42; // Returning a result
        };

        // Execute the Runnable task
        Thread runnableThread = new Thread(runnableTask);
        runnableThread.start();

        // Execute the Callable task (this is done through ExecutorService, which we'll cover shortly)
        Integer result = callableTask.call();
        System.out.println("Result from Callable: " + result);
    }
}
