package com.example.dijkstra.algorithm;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/*
 This class represent a single node in the graph.
 It just has an id (which corresponds to the id of a vertex in the graph) 
 and a distance from the start node. 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Node {
    private int id;
    private int distance;
}
