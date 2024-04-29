package com.javaholics;

import java.util.*;

/**
 * Represents a vertex in a graph.
 * Each vertex maintains a list of its adjacent vertices.
 * The graph is undirected, meaning that an edge between two vertices goes both
 * ways.
 * 
 * @author Lindsay Kislingbury
 * @author Lea Wiranatha
 */
public class Vertex {
    private String label;
    private List<Vertex> adjacentVertices;

    /**
     * Constructs a new vertex with the given label.
     * 
     * @param label The label of the vertex.
     */
    public Vertex(String label) {
        this.label = label;
        this.adjacentVertices = new ArrayList<>();
    }

    /**
     * Returns the label of this vertex.
     * 
     * @return The label of this vertex.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Returns a list of the vertices adjacent to this vertex.
     * 
     * @return A list of the vertices adjacent to this vertex.
     */
    public List<Vertex> getAdjacentVertices() {
        return adjacentVertices;
    }

    /**
     * Adds a vertex to the list of adjacent vertices.
     * 
     * @param vertex The vertex to add as an adjacent vertex.
     */
    public void addAdjacentVertex(Vertex vertex) {
        adjacentVertices.add(vertex);
    }
}