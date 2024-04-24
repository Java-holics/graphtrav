package com.javaholics;

import java.util.HashMap;
import java.util.Map;

public class Graph {
    private Map<String, Vertex> vertices;

    public Graph() {
        this.vertices = new HashMap<>();
    }

    public void addVertex(String label) {
        vertices.putIfAbsent(label, new Vertex(label));
    }

    public void addEdge(String label1, String label2) {
        Vertex vertex1 = vertices.get(label1);
        Vertex vertex2 = vertices.get(label2);
        if (vertex1 != null && vertex2 != null) {
            vertex1.addAdjacentVertex(vertex2);
            vertex2.addAdjacentVertex(vertex1);
        }
    }

    public Vertex getVertex(String label) {
        return vertices.get(label);
    }
}
