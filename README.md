Dijkstra's Algorithm Implementation
This is an implementation of Dijkstra's algorithm in Java using the classes Graph, Node, and DijkstraAlgorithm. The implementation is designed to be used with Spring Boot, and includes a REST API endpoint that accepts a JSON payload representing a graph and starting node, and returns a JSON payload representing the shortest distances from the starting node to all other nodes in the graph.

Graph Class
The Graph class represents a graph with a given number of vertices and a list of edges between those vertices. The edges are represented using an adjacency list, where each vertex has a list of adjacent vertices and the weight of the edge connecting them.

The Graph class has the following methods:

Graph(int numVertices): constructs a new graph with the given number of vertices.
void addEdge(int u, int v, int weight): adds an edge between vertices u and v with the given weight.
List<List<Node>> getAdjList(): returns the adjacency list for the graph.
int getNumVertices(): returns the number of vertices in the graph.

Node Class
The Node class represents a single node in the graph, along with its distance from the start node. It has two fields: id (which corresponds to the id of a vertex in the graph) and distance (which represents the distance from the start node).

DijkstraAlgorithm Class
The DijkstraAlgorithm class contains the implementation of Dijkstra's algorithm. It takes a Graph object and the id of the starting node as input, and returns a list of Node objects representing the shortest distance from the starting node to all other nodes in the graph.

The DijkstraAlgorithm class has the following methods:

List<Node> shortestPath(Graph graph, int startId): returns the shortest distance from the starting node to all other nodes in the graph.

DijkstraController Class
The DijkstraController class is a Spring Boot controller that defines an HTTP POST endpoint that accepts a JSON payload representing a graph and starting node, and returns a JSON payload representing the shortest distances from the starting node to all other nodes in the graph.

The DijkstraController class has the following methods:

List<Node> shortestPath(GraphRequest request): accepts a GraphRequest object and returns a list of Node objects representing the shortest distances from the starting node to all other nodes in the graph.
Usage
To use this implementation, you can send an HTTP POST request to the /shortest-path endpoint with a JSON payload representing the graph and starting node. The payload should have the following format:
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

