package com.javaholics;

/**
 * A driver class for the Graph class.
 * Prints the results of a depth-first and breadth-first traversal of a graph.
 * 
 * @author Lindsay Kislingbury
 * @author Lea Wiranatha
 */
public class GraphDriver {
    public static void main(String[] args) {
        Graph graph = new Graph();

        String[] vertices = { "A", "B", "C", "D", "E", "F", "G", "H", "I" };
        for (String vertex : vertices) {
            graph.addVertex(vertex);
        }

        String[][] edges = {
                { "A", "B" }, { "A", "D" }, { "A", "E" }, { "B", "E" }, { "D", "G" },
                { "E", "F" }, { "E", "H" }, { "G", "H" }, { "F", "C" }, { "F", "H" }, { "H", "I" },
                { "C", "B" }, { "I", "F" }
        };
        for (String[] edge : edges) {
            graph.addEdge(edge[0], edge[1]);
        }

        GraphAlgorithms algorithms = new GraphAlgorithms(graph);

        // Perform a depth-first traversal and print the traversal order
        System.out.println("\n");
        QueueInterface<String> traversalOrder = algorithms.getDepthFirstTraversal("A");
        System.out.println("Depth-first traversal:");
        while (!traversalOrder.isEmpty()) {
            System.out.print(traversalOrder.dequeue());
        }
        System.out.print("\n");

        // Perform a breadth-first traversal and print the traversal order
        System.out.println("\nBreadth-first traversal:");
        traversalOrder = algorithms.getBreadthFirstTraversal("A");
        while (!traversalOrder.isEmpty()) {
            System.out.print(traversalOrder.dequeue());
        }
        System.out.print("\n");
    }
}
