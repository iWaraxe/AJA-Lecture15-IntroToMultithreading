// File: Ex02ProducerConsumer.java
// Package: com.coherentsolutions.advanced.java.section04

package com.coherentsolutions.advanced.java.section04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This class demonstrates the Producer-Consumer problem using wait() and notify().
 * The producer generates data and puts it in a queue, while the consumer takes data from the queue.
 */
public class Ex02ProducerConsumer {

    private static final int CAPACITY = 5; // Capacity of the shared queue
    private static final Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        Thread producerThread = new Thread(new Producer(), "Producer");
        Thread consumerThread = new Thread(new Consumer(), "Consumer");

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
    }

    // Producer class that generates data
    static class Producer implements Runnable {
        @Override
        public void run() {
            int value = 0;
            while (true) {
                synchronized (queue) {
                    while (queue.size() == CAPACITY) {
                        try {
                            System.out.println("Queue is full. Producer is waiting...");
                            queue.wait(); // Wait until there's space in the queue
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }

                    System.out.println("Producer produced: " + value);
                    queue.add(value++);
                    queue.notify(); // Notify the consumer that new data is available
                }

                try {
                    Thread.sleep(1000); // Simulate time taken to produce a new item
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    // Consumer class that consumes data
    static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            System.out.println("Queue is empty. Consumer is waiting...");
                            queue.wait(); // Wait until there's data in the queue
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }

                    int value = queue.poll();
                    System.out.println("Consumer consumed: " + value);
                    queue.notify(); // Notify the producer that space is available
                }

                try {
                    Thread.sleep(1500); // Simulate time taken to consume an item
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
