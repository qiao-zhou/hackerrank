package algorithms.graph_theory;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zhou Qiao
 */

public class BFS_ShortestPath {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        int weight = 6;
        for(int t = 0; t < queries; t++) {
            
            // Create a graph of size n where each edge weight is 6:
            int num_nodes = scanner.nextInt();
            int num_edges = scanner.nextInt();
            
            Graph bfs = new Graph(num_nodes, weight);
            
            
            // read and set edges
            for(int i = 0; i < num_edges; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                
                // add each edge to the graph
                bfs.graph.get(u).add(v);
                bfs.graph.get(v).add(u);
            }
            
            // Find shortest reach from node s
            bfs.searchShortestPath(scanner.nextInt() - 1);
        }
        
        scanner.close();        
    }    
}

class Graph{
    public int numNodes;
    public int edgeWeight;
    public LinkedList<Integer> queue;
    public List<HashSet<Integer>> graph = new ArrayList<>();
    
    boolean[] visited_arr;
    int[] distance_arr;
    
    public Graph(int numNodes, int edgeWeight){
        this.numNodes = numNodes;
        this.edgeWeight  = edgeWeight;
        queue = new LinkedList<>();
        visited_arr = new boolean[numNodes];
        distance_arr = new int[numNodes];
        
        for(int i = 0; i < numNodes; i++){
            
            visited_arr[i] = false;
            distance_arr[i] = -1;
            graph.add(new HashSet<Integer>());
        }
        
    }
    
    public void searchShortestPath(int startNode){
        // add the current node into the unvisited list
        queue.add(startNode);
        //mark as visited and set distance to 0
        visited_arr[startNode] = true;
        distance_arr[startNode] = 0;
       
        //check for all unvisited nodes
        while(!queue.isEmpty()){
            int thisNode = queue.remove();
            
            //now visit all the neighbours 
            HashSet<Integer> neighbours = graph.get(thisNode);
            
            for(int neighbour: neighbours){
                if(!visited_arr[neighbour]){
                    
                    distance_arr[neighbour] = distance_arr[thisNode] + edgeWeight;
                    visited_arr[neighbour] = true;
                    
                    queue.add(neighbour);
                }
            }
            
        }
        
        for(int i=0; i<distance_arr.length;i++){
            if(i != startNode)
                System.out.print(distance_arr[i] + " ");
        }
        System.out.println();
    }
    
    
}
