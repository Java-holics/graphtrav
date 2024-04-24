package com.javaholics;

import java.util.*;
import java.util.Stack;

public class GraphAlgorithms implements GraphAlgorithmsInterface<String> {
    private Graph graph;

    public GraphAlgorithms(Graph graph) {
        this.graph = graph;
    }

    @Override
    public QueueInterface<String> getBreadthFirstTraversal(String origin) {
        // Create a queue to hold the vertices in the order they are visited
        QueueInterface<String> traversalOrder = new LinkedQueue<>();
        // Create a queue to hold vertices as they are visited
        Queue<String> vertexQueue = new LinkedList<>();
        // Create a set to hold the visited vertices
        Set<String> visited = new HashSet<>();

        // Mark the origin vertex as visited
        visited.add(origin);
        // Add the origin vertex to the traversal order
        traversalOrder.enqueue(origin);
        // Enqueue the origin vertex
        vertexQueue.add(origin);

        while (!vertexQueue.isEmpty()) {
            // Dequeue the front vertex
            String frontVertex = vertexQueue.poll();

            // Visit all unvisited neighbors of the front vertex
            for (Vertex adjacentVertex : graph.getVertex(frontVertex).getAdjacentVertices()) {
                if (!visited.contains(adjacentVertex.getLabel())) {
                    // Mark the neighbor as visited
                    visited.add(adjacentVertex.getLabel());
                    // Add the neighbor to the traversal order
                    traversalOrder.enqueue(adjacentVertex.getLabel());
                    // Enqueue the neighbor
                    vertexQueue.add(adjacentVertex.getLabel());
                }
            }
        }

        return traversalOrder;
    }

    @Override
    public QueueInterface<String> getDepthFirstTraversal(String origin) {
        // Create a queue to hold the vertices in the order they are visited
        QueueInterface<String> traversalOrder = new LinkedQueue<>();
        // Create a stack to hold vertices as they are visited
        Stack<String> vertexStack = new Stack<>();
        // Create a set to hold the visited vertices
        Set<String> visited = new HashSet<>();

        // Mark the origin vertex as visited
        visited.add(origin);
        // Add the origin vertex to the traversal order
        traversalOrder.enqueue(origin);
        // Push the origin vertex onto the stack
        vertexStack.push(origin);

        while (!vertexStack.isEmpty()) {
            // Peek at the top vertex on the stack
            String topVertex = vertexStack.peek();

            // Find an unvisited neighbor of the top vertex
            String nextNeighbor = null;
            for (Vertex adjacentVertex : graph.getVertex(topVertex).getAdjacentVertices()) {
                if (!visited.contains(adjacentVertex.getLabel())) {
                    nextNeighbor = adjacentVertex.getLabel();
                    break;
                }
            }

            if (nextNeighbor != null) {
                // Mark the next neighbor as visited
                visited.add(nextNeighbor);
                // Add the next neighbor to the traversal order
                traversalOrder.enqueue(nextNeighbor);
                // Push the next neighbor onto the stack
                vertexStack.push(nextNeighbor);
            } else {
                // All neighbors are visited, so pop the top vertex off the stack
                vertexStack.pop();
            }
        }

        return traversalOrder;
    }

    // Implement the other methods as needed
}
