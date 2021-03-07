package com.bbahaida.optimisation.graph.dfs;

import com.bbahaida.optimisation.graph.common.Vertex;

public class DFS {
    public void traverse(Vertex root, String search) {
        root.setVisited(true);
        System.out.println("Actual Visited Vertex: " + root);
        for (Vertex v : root.getAdjacencyList()) {
            if (!v.isVisited()) {
                traverse(v, search);
            }
        }
    }
}
