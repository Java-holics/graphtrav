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
        QueueInterface<String> traversalOrder = new LinkedQueue<>();
        Queue<String> vertexQueue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
    
        Vertex originVertex = graph.getVertex(origin);
        if (originVertex == null) {
            return traversalOrder;
        }
    
        vertexQueue.add(origin);
    
        while (!vertexQueue.isEmpty()) {
            String frontVertex = vertexQueue.poll();
    
            // Check if the vertex has already been visited
            if (!visited.contains(frontVertex)) {
                // Mark the vertex as visited
                visited.add(frontVertex);
                // Add the front vertex to the traversal order
                traversalOrder.enqueue(frontVertex);
    
                for (Vertex adjacentVertex : graph.getVertex(frontVertex).getAdjacentVertices()) {
                    String adjacentLabel = adjacentVertex.getLabel();
                    if (!visited.contains(adjacentLabel)) {
                        // Enqueue the adjacent vertex
                        vertexQueue.add(adjacentLabel);
                    }
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
        // Peek at the top vertex without removing it from the stack
        String currentVertex = vertexStack.peek();
        boolean hasUnvisitedNeighbor = false;

        // Visit all unvisited neighbors of the current vertex
        for (Vertex adjacentVertex : graph.getVertex(currentVertex).getAdjacentVertices()) {
            if (!visited.contains(adjacentVertex.getLabel())) {
                // Mark the neighbor as visited
                visited.add(adjacentVertex.getLabel());
                // Add the neighbor to the traversal order
                traversalOrder.enqueue(adjacentVertex.getLabel());
                // Push the neighbor onto the stack
                vertexStack.push(adjacentVertex.getLabel());
                hasUnvisitedNeighbor = true;
                break; // Move to the next vertex immediately
            }
        }

        // If all neighbors have been visited, backtrack by popping the current vertex
        if (!hasUnvisitedNeighbor) {
            vertexStack.pop();
        }
    }

    return traversalOrder;
}

    


}
