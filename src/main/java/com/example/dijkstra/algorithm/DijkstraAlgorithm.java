package com.example.dijkstra.algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
  This implementation of Dijkstra's algorithm uses a priority queue to keep track of the nodes 
  with the smallest distance from the start node. It starts by initializing all nodes with a 
  distance of infinity, except for the start node, which has a distance of 0. Then, it iteratively 
  selects the node with the smallest distance, updates the distances of its adjacent nodes 
  if necessary, and reinserts those nodes into the priority queue. This process repeats until 
  all nodes have been processed.

  The shortestPath method takes a Graph object and the id of the starting node, 
  and returns a list of Node objects representing the shortest distance from the starting node 
  to all other nodes in the graph.
 */
public class DijkstraAlgorithm {
    public List<Node> shortestPath(Graph graph, int startId) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(Node::getDistance));
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < graph.getNumVertices(); i++) {
            Node node = new Node(i, Integer.MAX_VALUE);
            if (i == startId) {
                node.setDistance(0);
            }
            nodes.add(node);
            pq.add(node);
        }

        while (!pq.isEmpty()) {
            Node u = pq.poll();
            for (Graph.Node v : graph.getAdjList().get(u.getId())) {
                int alt = u.getDistance() + v.getWeight();
                if (alt < nodes.get(v.getV()).getDistance()) {
                    nodes.get(v.getV()).setDistance(alt);
                    pq.remove(nodes.get(v.getV()));
                    pq.offer(nodes.get(v.getV()));
                }
            }
        }

        return nodes;
    }
}
