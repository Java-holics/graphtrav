package com.javaholics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GraphAlgorithmsTest {
    @Test
    public void testGetBreadthFirstTraversal() {
        // Create a new graph
        Graph graph = new Graph();

        // Add vertices to the graph
        String[] vertices = { "A", "B", "C", "D", "E", "F", "G", "H", "I" };
        for (String vertex : vertices) {
            graph.addVertex(vertex);
        }

        // Add edges to the graph
        String[][] edges = {
                { "A", "B" }, { "A", "D" }, { "A", "E" }, { "B", "E" }, { "D", "G" },
                { "E", "F" }, { "E", "H" }, { "G", "H" }, { "F", "C" }, { "F", "H" },
                { "H", "I" }, { "C", "B" }, { "I", "F" }
        };
        for (String[] edge : edges) {
            graph.addEdge(edge[0], edge[1]);
        }

        // Create a new GraphAlgorithms object
        GraphAlgorithms algorithms = new GraphAlgorithms(graph);

        // Perform a breadth-first traversal and check the traversal order
        QueueInterface<String> traversalOrder = algorithms.getBreadthFirstTraversal("A");
        String[] expectedOrder = { "A", "B", "D", "E", "G", "F", "H", "C", "I" };
        for (String vertex : expectedOrder) {
            assertEquals(vertex, traversalOrder.dequeue());
        }
    }
}