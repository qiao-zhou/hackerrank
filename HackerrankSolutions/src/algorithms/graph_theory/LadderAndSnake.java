package algorithms.graph_theory;

/**
 * Solution for Snakes and Ladders: The Quickest Way Up
 * https://www.hackerrank.com/challenges/the-quickest-way-up
 * @author Zhou Qiao
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LadderAndSnake {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named LadderAndSnake. */
        /*
        Sample Inputs: 
        2
        3
        32 62
        42 68
        12 98
        7
        95 13
        97 25
        93 37
        79 27
        75 19
        49 47
        67 17
        4
        8 52
        6 80
        26 42
        2 72
        9
        51 19
        39 11
        37 29
        81 3
        59 5
        79 23
        53 7
        43 33
        77 21
        
        Sample output:
        3
        5
        */
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for(int i = 0; i < q; i++){
            //for each qury, initiate the graph by adding the ladders and snakes
            LadderAndSnakeGraph graph = new LadderAndSnakeGraph();
            int n_ladder = scanner.nextInt();
            for(int j = 0; j < n_ladder; j++){
                int idx_i = scanner.nextInt();
                int idx_j = scanner.nextInt();
                graph.addLadder(idx_i, idx_j);
            }
            
            int n_snake = scanner.nextInt();
            for(int j = 0; j < n_snake; j++){
                int idx_i = scanner.nextInt();
                int idx_j = scanner.nextInt();
                graph.addSnake(idx_i, idx_j);
            }
            //start breadth first search to find the shortest path
            int answer = graph.bfSearch(0);
            System.out.println(answer);
        }
    }
    
}

//class representing the LadderAndSnake graph
//currently it is hard-coded to a board size of 10x10=100
class LadderAndSnakeGraph{
    public int[] jump_to_arr = new int[100];//initially all set to 0
    public boolean[] visited = new boolean[100];//initially all set to 0
    public int[] distance = new int[100];//disntance to reach the destination 
    LinkedList<Integer> queue = new LinkedList();
    
    public LadderAndSnakeGraph(){
       for(int i = 0; i < 100; i++){
           jump_to_arr[i] = i;
       }
    }
    
    public void addLadder(int i, int j){
        //if you reach i, you will jump to j immediately
        //thus you cannot really reach i, thus there is no node in the graph at i        
        jump_to_arr[i-1] = j-1;
    }
    
    public void addSnake(int i, int j){
        //if you reach i, you will jump to j immediately
        //thus you cannot really reach i, thus there is no node in the graph at i
        jump_to_arr[i-1] = j-1;
    }
    
    public int bfSearch(int start_ix){
    /*
    Breadth-first search for unweighted shortest path: basic idea

    By distance between two nodes u,v we mean the number of edges on the shortest path between u and v . Now:
    Start at the start vertex s . It is at distance 0 from itself, and there are no other nodes at distance 0
    Consider all the nodes adjacent to s . These all are at distance at most 1 from s (maybe less than 1, if s
    has an edge to itself; but then we would have found a shorter path already) and there are no other nodes at distance 1
    Consider all the nodes adjacent to the nodes adjacent to s . These are all at distance at most 2 from s (maybe less 
    than 2; but then we would have found a shorter path already) and there are no other nodes at distance 2
    ... and so on. In this breadth-first search, as soon as we visit a node in the graph, we know the shortest path from s to it; 
    and so by the time we have visited all the nodes in the graph, we know the shortest path from s to each of them        
    */
        //add te current node into the queue and mark as visited
        queue.add(start_ix);
        distance[start_ix] = 0;
        visited[start_ix] = true;
        
        //
        while(!queue.isEmpty()){
            int working_node = queue.remove();
            
            //redirect if it is a start of ladder or head of a snake
            working_node = jump_to_arr[working_node];
            visited[working_node] = true;
            
            //the adjacent list contains the next 6 spaces 
            for(int i =1; i<=6; i++){
                int next_node = working_node+i;
                if(next_node >= 0 && next_node < 100 && !visited[next_node]){
                    if(!visited[jump_to_arr[next_node]])
                        next_node = jump_to_arr[next_node];
                    queue.add(next_node);
                    visited[next_node] = true;
                    distance[next_node] = distance[working_node] + 1;
                }
                
            }
            
        }
        //return the distance; if not reached yet, return -1
        if(visited[distance.length-1])
            return distance[distance.length-1];
        else
            return -1;
    }    
}