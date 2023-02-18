package com.example.dijkstra.algorithm;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Edge {
    private int start;
    private int end;
    private int weight;
}
