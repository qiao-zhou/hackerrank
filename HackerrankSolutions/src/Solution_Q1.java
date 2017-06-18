
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
public class Solution_Q1 {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        //final String fileName = System.getenv("OUTPUT_PATH");
        //BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;
        
        int _friends_size = 0;
        _friends_size = Integer.parseInt(in.nextLine().trim());
        String[] _friends = new String[_friends_size];
        String _friends_item;
        for(int _friends_i = 0; _friends_i < _friends_size; _friends_i++) {
            try {
                _friends_item = in.nextLine();
            } catch (Exception e) {
                _friends_item = null;
            }
            _friends[_friends_i] = _friends_item;
        }
        
        res = friendCircles(_friends);
        //bw.write(String.valueOf(res));
        //bw.newLine();
        //bw.close();
    }
    
    static int friendCircles(String[] friends) {
        /**
         * The method I used is to keep a list of HashSet, with each set represents 
         * a friend circle. We dynamically update this list as we process each new 
         * friend pairs.  
         */
        //list of set, each set is a friend circle 
        List<HashSet<Integer>> list_of_circles = new ArrayList<>();
        
        //convert this matrix to a list of friend pairs 
        List<Integer[]> list_of_pairs = new ArrayList<>(); 
        for(int i=0; i <friends.length; i++){
            char[] relationships =  friends[i].toCharArray();
            
           //check each pairwise relatinship
            for(int j=0; j < friends[i].length();j++){
                //if is a friend, update the adjacency list 
                //if is not a friend, ignore this pair 
                if(relationships[j] == 'Y'){
                    Integer[] pair = new Integer[2];
                    pair[0] = i;
                    pair[1] = j;
                    list_of_pairs.add(pair);
                }
            }               
        }
        //process each friend pairs and geneate the final list of circles 
        for(int i = 0; i < list_of_pairs.size();i++){
            Integer[] pair = list_of_pairs.get(i);
            int first = pair[0];//first person in the pair 
            int second = pair[1];//second person in the pair 
            HashSet<Integer> set = new HashSet();
            set.add(first);
            set.add(second);
            
            int count = 0;
            int num_circles = list_of_circles.size();
            //as long as there are more circles to check, keep processing and updating the set 
            while(count < num_circles){
                //if either the first or second person is in a circle, merge these circles by putting them all into a new set
                if(list_of_circles.get(count).contains(first) || list_of_circles.get(count).contains(second)){
                    set.addAll(list_of_circles.get(count));
                    //once added into the new set, remove the original circle and reduce the num of circles by 1
                    list_of_circles.remove(count);
                    num_circles--;
                }else{
                    count++;
                }
            }
            //add the merged circle into the list 
            list_of_circles.add(set);
        }
        

        return 0;
    }  
}
