package com.javaholics;

import java.util.*;

public class Vertex {
    private String label;
    private List<Vertex> adjacentVertices;

    public Vertex(String label) {
        this.label = label;
        this.adjacentVertices = new ArrayList<>();
    }

    public String getLabel() {
        return label;
    }

    public List<Vertex> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void addAdjacentVertex(Vertex vertex) {
        adjacentVertices.add(vertex);
    }
}