package com.javaholics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VertexTest {
    private Vertex vertex;

    @BeforeEach
    public void setup() {
        vertex = new Vertex("A");
    }

    @Test
    public void testGetLabel() {
        assertEquals("A", vertex.getLabel());
    }

    @Test
    public void testGetAdjacentVertices() {
        assertTrue(vertex.getAdjacentVertices().isEmpty());
        Vertex adjacentVertex = new Vertex("B");
        vertex.addAdjacentVertex(adjacentVertex);
        assertEquals(1, vertex.getAdjacentVertices().size());
        assertEquals(adjacentVertex, vertex.getAdjacentVertices().get(0));
    }

    @Test
    public void testAddAdjacentVertex() {
        Vertex adjacentVertex = new Vertex("B");
        vertex.addAdjacentVertex(adjacentVertex);
        assertEquals(1, vertex.getAdjacentVertices().size());
        assertEquals(adjacentVertex, vertex.getAdjacentVertices().get(0));
    }
}