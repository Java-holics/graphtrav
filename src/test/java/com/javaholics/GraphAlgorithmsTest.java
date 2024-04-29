package com.javaholics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GraphAlgorithmsTest {
    @Test
    public void testGetBreadthFirstTraversal_EmptyGraph() {
        Graph emptyGraph = new Graph();
        GraphAlgorithms algorithms = new GraphAlgorithms(emptyGraph);
        QueueInterface<String> traversalOrder = algorithms.getBreadthFirstTraversal("A");
        assertTrue(traversalOrder.isEmpty());
    }

    @Test
    public void testGetBreadthFirstTraversal_NonexistentOrigin() {
        GraphAlgorithms algorithms = new GraphAlgorithms(new Graph());
        QueueInterface<String> traversalOrder = algorithms.getBreadthFirstTraversal("Z");
        assertTrue(traversalOrder.isEmpty());
    }
}