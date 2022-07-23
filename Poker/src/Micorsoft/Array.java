package Micorsoft;

import java.util.HashSet;
import java.util.Set;

public class Array {



    public static int findIndex(int[] in){
        Set<Integer> set = new HashSet<>();
        for(int x : in){
            set.add(x);
        }
        int size = set.size();
        set.clear();
        int count = 0;
        for(int i = 0; i < in.length; i++){
            set.add(in[i]);
            if(set.size() == size){
                count = i;
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] input = {1,1,2,3,4,2,1};
        System.out.println(findIndex(input));
    }
}
