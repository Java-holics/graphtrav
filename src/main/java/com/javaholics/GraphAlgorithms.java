package com.javaholics;

import java.util.*;

/**
 * Provides graph algorithms for traversing a graph.
 * This class implements the GraphAlgorithmsInterface and provides methods for
 * performing breadth-first and depth-first traversals of a graph.
 * 
 * @author Lindsay Kislingbury
 * @author Lea Wiranatha
 */
public class GraphAlgorithms implements GraphAlgorithmsInterface<String> {
    private Graph graph;

    /**
     * Constructs a new GraphAlgorithms object for the given graph.
     * 
     * @param graph The graph to traverse.
     */
    public GraphAlgorithms(Graph graph) {
        this.graph = graph;
    }

    /**
     * Performs a breadth-first traversal of this graph, starting at the given
     * origin vertex.
     * This method uses a queue to keep track of the vertices to visit next.
     * 
     * @param origin A string that labels the origin vertex of the traversal.
     * @return A queue containing the labels of the vertices in the order they were
     *         visited
     */
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
            if (!visited.contains(frontVertex)) {
                visited.add(frontVertex);
                traversalOrder.enqueue(frontVertex);
                for (Vertex adjacentVertex : graph.getVertex(frontVertex).getAdjacentVertices()) {
                    String adjacentLabel = adjacentVertex.getLabel();
                    if (!visited.contains(adjacentLabel)) {
                        vertexQueue.add(adjacentLabel);
                    }
                }
            }
        }
        return traversalOrder;
    }

    /**
     * Performs a depth-first traversal of this graph, starting at the given origin
     * vertex.
     * This method uses a stack to keep track of the vertices to visit next.
     * This method returns a queue containing the labels of the vertices in the
     * order they were visited.
     * 
     * @param origin A string that labels the origin vertex of the traversal.
     * @return A queue containing the labels of the vertices in the order they were
     *         visited
     */
    @Override
    public QueueInterface<String> getDepthFirstTraversal(String origin) {
        QueueInterface<String> traversalOrder = new LinkedQueue<>();
        Stack<String> vertexStack = new Stack<>();
        Set<String> visited = new HashSet<>();
        visited.add(origin);
        traversalOrder.enqueue(origin);
        vertexStack.push(origin);

        while (!vertexStack.isEmpty()) {
            String currentVertex = vertexStack.peek();
            boolean hasUnvisitedNeighbor = false;
            for (Vertex adjacentVertex : graph.getVertex(currentVertex).getAdjacentVertices()) {
                if (!visited.contains(adjacentVertex.getLabel())) {
                    visited.add(adjacentVertex.getLabel());
                    traversalOrder.enqueue(adjacentVertex.getLabel());
                    vertexStack.push(adjacentVertex.getLabel());
                    hasUnvisitedNeighbor = true;
                    break;
                }
            }
            if (!hasUnvisitedNeighbor) {
                vertexStack.pop();
            }
        }

        return traversalOrder;
    }
}
