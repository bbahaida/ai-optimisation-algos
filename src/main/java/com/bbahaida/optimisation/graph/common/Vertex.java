package com.bbahaida.optimisation.graph.common;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString(onlyExplicitlyIncluded = true)
public class Vertex {
    @ToString.Include
    private String name;
    private boolean visited;
    private List<Vertex> adjacencyList = new ArrayList<>();

    public void addNeighbor(Vertex vertex) {
        this.adjacencyList.add(vertex);
    }

    public Vertex(String name) {
        this.name = name;
    }
}
