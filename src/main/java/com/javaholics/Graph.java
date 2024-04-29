package com.javaholics;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a graph data structure.
 * This class uses an adjacency list representation of a graph, where each
 * vertex maintains a list of its adjacent vertices.
 * The graph is undirected, meaning that an edge between two vertices goes both
 * ways.
 * 
 * @author Lindsay Kislingbury
 * @author Lea Wiranatha
 */
public class Graph {
    private Map<String, Vertex> vertices;

    /**
     * Constructs a new, empty graph.
     */
    public Graph() {
        this.vertices = new HashMap<>();
    }

    /**
     * Adds a vertex to the graph with the given label.
     * If a vertex with the given label already exists in the graph, this method
     * does nothing.
     * 
     * @param label The label of the vertex to add.
     */
    public void addVertex(String label) {
        vertices.putIfAbsent(label, new Vertex(label));
    }

    /**
     * Adds a vertex with the given label to the graph.
     * If a vertex with the given label already exists in the graph, this method
     * does nothing.
     * 
     * @param label1 The label of the first vertex.
     * @param label2 The label of the second vertex.
     */
    public void addEdge(String label1, String label2) {
        Vertex vertex1 = vertices.get(label1);
        Vertex vertex2 = vertices.get(label2);
        if (vertex1 != null && vertex2 != null) {
            vertex1.addAdjacentVertex(vertex2);
            vertex2.addAdjacentVertex(vertex1);
        }
    }

    /**
     * Returns the vertex with the given label.
     * 
     * @param label The label of the vertex to return.
     * @return The vertex with the given label, or null if no such vertex exists.
     */
    public Vertex getVertex(String label) {
        return vertices.get(label);
    }
}
