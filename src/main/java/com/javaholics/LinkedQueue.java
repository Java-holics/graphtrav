package com.javaholics;

import java.util.LinkedList;

/**
 * Represents a queue data structure using a linked list.
 * This class implements the QueueInterface and provides methods for
 * adding, removing, and checking the front of the queue.
 * This class uses a linked list to store the data in the queue.
 * 
 * @param <T> The type of data stored in the queue.
 * 
 * @author Lindsay Kislingbury
 * @author Lea Wiranatha
 */
public class LinkedQueue<T> implements QueueInterface<T> {
    private LinkedList<T> list;

    /**
     * Constructs a new, empty queue.
     */
    public LinkedQueue() {
        list = new LinkedList<>();
    }

    /**
     * Adds a new entry to the back of this queue.
     * 
     * @param newEntry The entry to add to the queue.
     */
    @Override
    public void enqueue(T newEntry) {
        list.addLast(newEntry);
    }

    /**
     * Removes and returns the entry at the front of this queue.
     * 
     * @return The entry at the front of the queue.
     */
    @Override
    public T dequeue() {
        return list.pollFirst();
    }

    /**
     * Retrieves the entry at the front of this queue.
     * 
     * @return The entry at the front of the queue.
     */
    @Override
    public T getFront() {
        return list.peekFirst();
    }

    /**
     * Checks whether this queue is empty.
     * 
     * @return True if the queue is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Removes all entries from this queue.
     * The queue will be empty after this method returns.
     */
    @Override
    public void clear() {
        list.clear();
    }

    /**
     * Checks whether this queue contains the given entry.
     * 
     * @param entry The entry to check for in the queue.
     * @return True if the queue contains the entry, false otherwise.
     */
    public boolean contains(T entry) {
        return list.contains(entry);
    }
}