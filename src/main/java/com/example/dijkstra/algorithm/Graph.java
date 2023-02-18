package com.example.dijkstra.algorithm;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


/* 
This class defines a graph, where each vertex is represented by an integer from 0 to V-1. 
The addEdge method allows you to add an edge to the graph, specifying the starting vertex, 
ending vertex, and weight of the edge. The Node class is used to represent an adjacent vertex 
and the weight of the edge connecting the two vertices. 
*/

@Data
@NoArgsConstructor
public class Graph {
    private int V; // number of vertices
    private List<List<Node>> adjList;

    public Graph(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int weight) {
        adjList.get(u).add(new Node(v, weight));
    }

    public List<List<Node>> getAdjList() {
        return adjList;
    }

    public int getNumVertices() {
        return V;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Node {
        int v;
        int weight;
    }
}
