package com.bbahaida.optimisation.graph.dfs;

import com.bbahaida.optimisation.graph.common.Vertex;

import java.util.Stack;

public class DFS {
    public void traverseUsingRecursion(Vertex root, String search) {
        root.setVisited(true);
        System.out.println("Actual Visited Vertex: " + root);
        for (Vertex v : root.getAdjacencyList()) {
            if (!v.isVisited()) {
                traverseUsingRecursion(v, search);
            }
        }
    }
    public void traverseUsingStack(Vertex root, String search) {
        Stack<Vertex> stack = new Stack<>();
        stack.push(root);
        root.setVisited(true);
        while (!stack.isEmpty()) {
            Vertex actualVertex = stack.pop();
            System.out.println("Actual Visited Vertex: " + actualVertex);
            for (Vertex v : actualVertex.getAdjacencyList()) {
                if (!v.isVisited()) {
                    v.setVisited(true);
                    stack.push(v);
                }
            }
        }
    }
}
