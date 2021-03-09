package com.bbahaida.optimisation;

import com.bbahaida.optimisation.graph.bfs.BFS;
import com.bbahaida.optimisation.graph.common.Vertex;
import com.bbahaida.optimisation.graph.dfs.DFS;

public class Application {

    public static void main(String[] args) {
        traverseWithDFSStack(getGraph(), "C");
        /*System.out.println("---------------------------------");
        traverseWithDFS(getGraph(), "C");*/
        System.out.println("---------------------------------");
        traverseWithBFS(getGraph(), "C");
    }

    private static void traverseWithBFS(Vertex graph, String search) {
        BFS bfs = new BFS();

        bfs.traverse(graph, search);
    }

    private static void traverseWithDFS(Vertex graph, String search) {
        DFS dfs = new DFS();

        dfs.traverseUsingRecursion(graph, search);
    }

    private static void traverseWithDFSStack(Vertex graph, String search) {
        DFS dfs = new DFS();

        dfs.traverseUsingStack(graph, search);
    }

    private static Vertex getGraph() {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");


        // A
        a.addNeighbor(b);
        a.addNeighbor(f);
        a.addNeighbor(g);

        // B
        b.addNeighbor(a);
        b.addNeighbor(c);
        b.addNeighbor(d);

        // C
        c.addNeighbor(b);

        // D
        d.addNeighbor(b);
        d.addNeighbor(e);

        // E
        e.addNeighbor(d);

        // F
        f.addNeighbor(a);

        // G
        g.addNeighbor(a);
        g.addNeighbor(h);

        // H
        h.addNeighbor(g);
        return a;
    }
}
