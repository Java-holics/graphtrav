package com.javaholics;

import java.util.LinkedList;

public class LinkedQueue<T> implements QueueInterface<T> {
    private LinkedList<T> list;

    public LinkedQueue() {
        list = new LinkedList<>();
    }

    @Override
    public void enqueue(T newEntry) {
        list.addLast(newEntry);
    }

    @Override
    public T dequeue() {
        return list.pollFirst();
    }

    @Override
    public T getFront() {
        return list.peekFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void clear() {
        list.clear();
    }

    public boolean contains(T entry) {
        return list.contains(entry);
    }
}