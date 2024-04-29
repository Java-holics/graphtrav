package com.javaholics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedQueueTest {
    private LinkedQueue<Integer> queue;

    @BeforeEach
    public void setup() {
        queue = new LinkedQueue<>();
    }

    @Test
    public void testEnqueue() {
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.getFront());
    }

    @Test
    public void testDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.getFront());
    }

    @Test
    public void testGetFront() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.getFront());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testClear() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertFalse(queue.isEmpty());
        queue.clear();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testContains() {
        assertFalse(queue.contains(1));
        queue.enqueue(1);
        assertTrue(queue.contains(1));
    }
}