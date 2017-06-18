import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class SolutionQ2 {
/*
 * Complete the function below.
 */
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        //final String fileName = System.getenv("OUTPUT_PATH");
        //BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;
        
        int _words_size = 0;
        _words_size = Integer.parseInt(in.nextLine().trim());
        String[] _words = new String[_words_size];
        String _words_item;
        for(int _words_i = 0; _words_i < _words_size; _words_i++) {
            try {
                _words_item = in.nextLine();
            } catch (Exception e) {
                _words_item = null;
            }
            _words[_words_i] = _words_item;
        }
        
        res = longestChain(_words);
        System.out.println(res);
        //bw.write(String.valueOf(res));
        //bw.newLine();
        
        //bw.close();
    }

    static int longestChain(String[] words) {
        //put them into an array list 
        List<String> words_list = new ArrayList();
        for(int i = 0; i < words.length; i++){
            words_list.add(words[i]);
        }
        //sort the list by length of string 
        Collections.sort(words_list, new StringLengthComparator());
        
        
        //
        int n = words_list.size();
        int[] max_till_current = new int[n];
        max_till_current[0] = 1;
        
        for(int i = 1; i < n;i++){
            int max = 1;
            for(int j = i-1; j>=0; j--){
                if(words_list.get(i).length() > words_list.get(j).length()){
                    if(words_list.get(i).length() - words_list.get(j).length()==1){
                        String str_longer = words_list.get(i);
                        String str_shorter = words_list.get(j);
                        
                        for(int cutix = 0; cutix < str_longer.length();cutix++){
                            String after_r = str_longer.substring(0, cutix) + str_longer.substring(cutix+1, str_longer.length());
                            if(after_r.equals(str_shorter) && max_till_current[j]+ 1 > max){
                                max = max_till_current[j] + 1;
                            }
                        }
                    }else{
                        //no need to check further
                        break;
                    }
                }
            }
            max_till_current[i] = max;
        }
        
        // find the maximum 
        int max = -1;
        for(int i =0; i < n; i++){
            if(max_till_current[i] > max){
                max = max_till_current[i];
            }
        }
        return max;
    }

    static class StringLengthComparator implements Comparator<String>{

        @Override
        public int compare(String t, String t1) {
            return t.length() - t1.length();
        }

    }
    
    
    
}



