package com.example.dijkstra.request;

import java.util.List;

import com.example.dijkstra.algorithm.Edge;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GraphRequest {
    private int numVertices;
    private int start;
    private List<Edge> edges;        
}
