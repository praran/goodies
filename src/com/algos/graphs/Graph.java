package com.algos.graphs;


import java.util.*;



/**
 */
public class Graph {

    private Map<String, List<String>>  edges = new HashMap<String, List<String>> ();


    public void addEdge(String src, String dest){
        List<String> edge = edges.get(src);
        if(edge ==null){
            this.edges.put(src, edge = new ArrayList<String>());
        }
        edge.add(dest);
    }

    public List<String> getNeighbours(String src){
        List<String> neighbours = this.edges.get(src);
        if(neighbours == null) return Collections.EMPTY_LIST;
        else return Collections.unmodifiableList(neighbours);
    }


    public static void main(String... args){
        Graph graph = new Graph();
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("A", "D");
        graph.addEdge("B", "E");
        graph.addEdge("B", "F");
        graph.addEdge("C", "F");

       // graph.DFS("A");
        graph.BFS("A");

    }

    public void BFS(String root){

        if(!edges.containsKey(root)) return;
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        queue.add(root);
        visited.add(root);
        System.out.println(root);

        while(!queue.isEmpty()){
            String v = queue.remove();
            String neighbour = null;
            while((neighbour = getUnvisitedChildren(this.getNeighbours(v), visited)) != null){
                visited.add(neighbour);
                System.out.println(neighbour);
                queue.add(neighbour);
            }
        }

    }

    public void DFS(String root){
        Stack<String> stack = new Stack<String>();
        Set<String> visited = new HashSet<String>();
        if(!edges.containsKey(root)) return;
        stack.push(root);
        visited.add(root);

        System.out.println(root);
        while(!stack.isEmpty()){
            String s = stack.peek();
            String neighbour = getUnvisitedChildren(this.getNeighbours(s), visited);
            if(neighbour != null){
                visited.add(neighbour);
                System.out.println(neighbour);
                stack.push(neighbour);
            }else{
                stack.pop();
            }
        }

    }

    /// http://www.codeproject.com/Articles/32212/Introduction-to-Graph-with-Breadth-First-Search-BF


    private String getUnvisitedChildren(List<String> children , Set<String> visited){
        String unVisited = null;
        for(String s : children){
            if(!visited.contains(s)){
                unVisited = s;
                break;
            }
        }

        return unVisited;
    }

}
