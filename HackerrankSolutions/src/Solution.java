import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution {
   public static void main(String[] args) throws Exception{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = bfr.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int I = Integer.parseInt(temp[1]);
      

        List<HashSet<Integer>> list_of_set = new ArrayList<>();
//        for(int i=0; i <N;i++){
//            HashSet<Integer> set = new HashSet<>();
//            set.add(i);
//            list_of_set.add(set);
//        }
        long tot_not_visited = N;
        
        for(int i = 0; i < I; i++){
            temp = bfr.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
          // Store a and b in an appropriate data structure of your choice
            int loc_a = -1;
            int loc_b = -1;
            
            for(int j=0; j < list_of_set.size();j++){
                HashSet<Integer> set = list_of_set.get(j);
                if(set.contains(a)){
                    loc_a = j;
                }
                if(set.contains(b)){
                    loc_b = j;
                }   
                if(loc_a != -1 && loc_b !=-1) 
                    break;
            }
            
            //if neither is found
            if(loc_a == -1 && loc_b==-1){
                HashSet<Integer> set = new HashSet<>();
                set.add(a);
                set.add(b);
                list_of_set.add(set);
                tot_not_visited -= 2;
            }
            else if(loc_a != -1 && loc_b == -1){
                list_of_set.get(loc_a).add(b);
                tot_not_visited -= 1;
            }
            else if(loc_b != -1 && loc_a==-1){
                list_of_set.get(loc_b).add(a);
                tot_not_visited -= 1;
            }
            //both are already in the list but in different list, merge them 
            else if(loc_a != -1 && loc_b!=-1 && loc_a!= loc_b){
                //add all elements in b to a
                list_of_set.get(loc_a).addAll(list_of_set.get(loc_b));
                // remove b
                //list_of_set.remove(loc_b);
                list_of_set.set(loc_b, new HashSet());
            }
            
        }
        
       
   
        //long combinations = 0;
        BigInteger combinations = BigInteger.valueOf(0);
        //combinations = list_of_set.size() * (list_of_set.size()-1);
        for(int i=0; i < list_of_set.size(); i++){
            int n1 = list_of_set.get(i).size();
            //combinations += n1 * (N-n1); 
            combinations = combinations.add(BigInteger.valueOf(n1 * (N-n1)));
            
        }
        //long tmp = tot_not_visited*(N-1);
        combinations = combinations.add(BigInteger.valueOf(tot_not_visited*(N-1)));
        //combinations += tmp;
        combinations = combinations.divide(BigInteger.valueOf(2));
        
        //combinations /= 2;
        // Compute the final answer - the number of combinations
       
        System.out.println(combinations);

    }
}

 
