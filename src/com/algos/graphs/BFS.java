package com.algos.graphs;

import java.util.*;

/**
 */
public class BFS {

    private Set<String> visited = new HashSet<String>();

    private Queue<String> queue = new LinkedList<String>();

    private Graph graph;

    public BFS(Graph graph, String startingVertesx){
        this.graph = graph;
        this.queue.add(startingVertesx);
        this.visited.add(startingVertesx);
    }


    public void DFS(){
        String next = queue.remove();

        for(String s : this.graph.getNeighbours(next)){

        }
    }

    public void BFS(){}
}
