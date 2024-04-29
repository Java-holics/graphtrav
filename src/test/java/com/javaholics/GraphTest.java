package com.javaholics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {
    private Graph graph;

    @BeforeEach
    public void setup() {
        graph = new Graph();
    }

    @Test
    public void testAddVertex() {
        assertNull(graph.getVertex("A"));
        graph.addVertex("A");
        assertNotNull(graph.getVertex("A"));
        assertEquals("A", graph.getVertex("A").getLabel());
    }

    @Test
    public void testAddEdge() {
        graph.addVertex("A");
        graph.addVertex("B");
        assertTrue(graph.getVertex("A").getAdjacentVertices().isEmpty());
        assertTrue(graph.getVertex("B").getAdjacentVertices().isEmpty());

        graph.addEdge("A", "B");
        assertEquals(1, graph.getVertex("A").getAdjacentVertices().size());
        assertEquals(1, graph.getVertex("B").getAdjacentVertices().size());
        assertEquals("B", graph.getVertex("A").getAdjacentVertices().get(0).getLabel());
        assertEquals("A", graph.getVertex("B").getAdjacentVertices().get(0).getLabel());
    }

    @Test
    public void testGetVertex_ExistingVertex() {
        graph.addVertex("A");
        Vertex vertex = graph.getVertex("A");
        assertNotNull(vertex);
        assertEquals("A", vertex.getLabel());
    }

    @Test
    public void testGetVertex_NonexistentVertex() {
        Vertex vertex = graph.getVertex("Z");
        assertNull(vertex);
    }

    @Test
    public void testAddEdge_VerticesExist() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B");
        Vertex vertexA = graph.getVertex("A");
        Vertex vertexB = graph.getVertex("B");
        assertTrue(vertexA.getAdjacentVertices().contains(vertexB));
        assertTrue(vertexB.getAdjacentVertices().contains(vertexA));
    }

    @Test
    public void testAddEdge_VerticesDoNotExist() {
        graph.addEdge("Z", "Y");
        Vertex vertexZ = graph.getVertex("Z");
        Vertex vertexY = graph.getVertex("Y");
        assertNull(vertexZ);
        assertNull(vertexY);
    }
}