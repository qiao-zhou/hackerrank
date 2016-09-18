package algorithms.graph_theory;


/**
 * Even Tree
 * https://www.hackerrank.com/challenges/even-tree
 * @author Zhou Qiao
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class EvenTree {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named EvenTree. */
        /*
        Sample Input:
        10 9
        2 1
        3 1
        4 3
        5 2
        6 1
        7 2
        8 6
        9 8
        10 8     
        Sample Output
        2
        */     
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//number of vertices 
        int M = scanner.nextInt();//number of edges 
        
        HashMap<Integer, ArrayList<Integer>> tree_map = new HashMap();
        
        //initiate the tree 
        for(int i =0; i < M; i++){
            int node1 = scanner.nextInt()-1;//-1 to convert to index from 0-9
            int node2 = scanner.nextInt()-1;
            if(node1>node2){
                int tmp = node1;
                node1 = node2;
                node2 = tmp;
            }
            if(tree_map.containsKey(node1)){
                tree_map.get(node1).add(node2);
            }else{
                tree_map.put(node1, new ArrayList<Integer>());
                tree_map.get(node1).add(node2);
            }
        }
        
        EvenTreeGraph graph = new EvenTreeGraph(N, tree_map);
        int count = graph.searchTree();
        
        System.out.println(count);    
    }
}

class EvenTreeGraph{
    int N;
    int count;
    LinkedList<Integer> queue = new LinkedList<>();
    HashMap<Integer, ArrayList<Integer>> tree_map;
    
    public EvenTreeGraph(int N, HashMap<Integer, ArrayList<Integer>> tree_map){
        count = 0;    
        this.tree_map = tree_map;
    }
    
    public ArrayList<Integer> findChildren(int node){
        //find the number of direct (adjacent) children 
        if(tree_map.containsKey(node)){
            return tree_map.get(node);
        }else{
            return new ArrayList<>();
        }
    }
    
    public int findNumNodesInTheSubTree(int node){
        //find total number of nodes under this node
        ArrayList<Integer> children = findChildren(node);
        int num = 0;
        if(children.isEmpty()) 
            return 0;
        for(int child: children){
            num += (findNumNodesInTheSubTree(child));
        }
        
        return num+children.size();
    }
    
    public int searchTree(){
        count = 0;//resent count 
        int rootix = 0;
        queue.add(rootix);
        
        //while has more unvisited nodes 
        while(!queue.isEmpty()){
            int working_node = queue.remove();
            //find all its children (adjacent nodes)
            ArrayList<Integer> children = this.findChildren(working_node);
            
            for(int child: children){
            //if not visited, mark as visited and add into the queue 
            //find number of its children , if number is odd, the link to its parent can be cut
                int numNodesInSubTree = findNumNodesInTheSubTree(child);
                if(numNodesInSubTree % 2 == 1){
                    count++;
                }
            }
            queue.addAll(children);
        }   
        
        return count;
    }
}