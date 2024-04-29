package com.javaholics;

/**
 * An interface for the ADT queue.
 * 
 * @param <T> The type of the objects in the queue.
 */
public interface QueueInterface<T> {
    /**
     * Adds a new entry to the back of this queue.
     * 
     * @param newEntry The entry to add to the queue.
     */
    void enqueue(T newEntry);

    /**
     * Removes and returns the entry at the front of this queue.
     * 
     * @return The entry at the front of the queue.
     */
    T dequeue();

    /**
     * Retrieves the entry at the front of this queue.
     * 
     * @return The entry at the front of the queue.
     */
    T getFront();

    /**
     * Checks whether this queue is empty.
     * 
     * @return True if the queue is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Removes all entries from this queue.
     * The queue will be empty after this method returns.
     */
    void clear();
}