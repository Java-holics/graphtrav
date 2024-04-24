package com.javaholics;

public class GraphDriver {
    public static void main(String[] args) {
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
                { "E", "H" }, { "E", "F" }, { "G", "H" }, { "H", "I" }, { "F", "H" }, { "I", "F" },
                { "F", "C" }, { "C", "B" }
        };
        for (String[] edge : edges) {
            graph.addEdge(edge[0], edge[1]);
        }

        // Create a new GraphAlgorithms object
        GraphAlgorithms algorithms = new GraphAlgorithms(graph);

        // Perform a depth-first traversal and print the traversal order
        QueueInterface<String> traversalOrder = algorithms.getDepthFirstTraversal("A");
        System.out.println("Depth-first traversal:");
        while (!traversalOrder.isEmpty()) {
            System.out.println(traversalOrder.dequeue());
        }

        // Perform a breadth-first traversal and print the traversal order
        System.out.println("\nBreadth-first traversal:");
        traversalOrder = algorithms.getBreadthFirstTraversal("A");
        while (!traversalOrder.isEmpty()) {
            System.out.println(traversalOrder.dequeue());
        }
    }
}
