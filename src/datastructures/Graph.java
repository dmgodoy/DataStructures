package datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Graph {

    static class GraphNode { // nested class doesn't need particular Graph
                                // instance to instantiate
        int value;
        List<GraphNode> neighbors = new ArrayList<>();

        public GraphNode(int value, List<GraphNode> neighbors) {
            this.value = value;
            this.neighbors = neighbors;
        }

        public GraphNode(int value) {
            this.value = value;
        }

        public void setNeighBors(List<GraphNode> neighbors) {
            this.neighbors = neighbors;
        }
    }

    public static void depthFirstSearch(GraphNode node) {
        depthFirstSearch(node, new HashSet<>());
    }

    public static void breadthFirstSearch(GraphNode node) {
        Queue<GraphNode> fifo = new LinkedList<>();
        Set<GraphNode> visited = new HashSet<>();
        fifo.add(node);
        visited.add(node);
        while (!fifo.isEmpty()) {
            GraphNode n = fifo.poll();
            System.out.println(n.value);
            for (GraphNode neighbor : n.neighbors) {
                if (!visited.contains(neighbor)) {
                    fifo.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    private static void depthFirstSearch(GraphNode node, Set<GraphNode> visited) {
        if (visited.contains(node))
            return;
        visited.add(node);
        for (GraphNode n : node.neighbors)
            depthFirstSearch(n, visited);
        System.out.println(node.value);
    }

    public static void main(String[] args) {
        GraphNode[] nodes = new GraphNode[10];
        for (int i = 0; i < nodes.length; i++)
            nodes[i] = new Graph.GraphNode(i + 1);
        nodes[0].setNeighBors(Arrays.asList(nodes[1], nodes[2], nodes[3]));
        nodes[3].setNeighBors(Arrays.asList(nodes[4], nodes[5], nodes[6]));
        nodes[6].setNeighBors(Arrays.asList(nodes[7], nodes[8], nodes[9]));
        nodes[1].setNeighBors(Arrays.asList(nodes[0])); // cycle :)
        System.out.println("Depth First Search : ");
        depthFirstSearch(nodes[0]);
        System.out.println();
        System.out.println("Breadth First Search : ");
        breadthFirstSearch(nodes[0]);
    }

}
