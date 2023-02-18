package com.example.dijkstra.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dijkstra.algorithm.Node;
import com.example.dijkstra.request.GraphRequest;
import com.example.dijkstra.algorithm.DijkstraAlgorithm;
import com.example.dijkstra.algorithm.Edge;
import com.example.dijkstra.algorithm.Graph;

/*
   This class creates a REST API endpoint that accepts a JSON payload representing the graph 
   and starting node, and returns a JSON payload representing the shortest distances.
   
   Request:
    {
    "numVertices": 5,
    "start": 0,
    "edges": [
        { "start": 0, "end": 1, "weight": 10 },
        { "start": 0, "end": 2, "weight": 3 },
        { "start": 1, "end": 2, "weight": 1 },
        { "start": 1, "end": 3, "weight": 2 },
        { "start": 2, "end": 1, "weight": 4 },
        { "start": 2, "end": 3, "weight": 8 },
        { "start": 2, "end": 4, "weight": 2 },
        { "start": 3, "end": 4, "weight": 7 },
        { "start": 4, "end": 3, "weight": 9 }
    ]
    }

  Response:
  [
    { "id": 0, "distance": 0 },
    { "id": 1, "distance": 7 },
    { "id": 2, "distance": 3 },
    { "id": 3, "distance": 9 },
    { "id": 4, "distance": 5 }
  ]

 */
@RestController
public class DijkstraController {
    @PostMapping("/shortest-path")
    public List<Node> shortestPath(@RequestBody GraphRequest request) {
        Graph graph = new Graph(request.getNumVertices());
        for (Edge edge : request.getEdges()) {
            graph.addEdge(edge.getStart(), edge.getEnd(), edge.getWeight());
        }
        DijkstraAlgorithm algorithm = new DijkstraAlgorithm();
        return algorithm.shortestPath(graph, request.getStart());
    }    
}
