package Alibaba;

import java.io.*;
import java.util.*;

public class Main11{
    private static int res = 0;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
//        List<Integer> list = new ArrayList<>();
//        while(sc.hasNextInt()){
//            list.add(sc.nextInt());
//        }
        String[] ss = sc.nextLine().split(" ");
        int N = Integer.parseInt(ss[0]);
        int[] tree = new int[N];
        for(int i = 1; i <= N; i++){
            tree[i - 1] = Integer.parseInt(ss[i]);
        }

        if(dfs(tree, 0) == 3){
            res++;
        }
        System.out.println(res);
    }
    public static int dfs(int[] tree, int index){
        if(index >= 0 && index < tree.length && tree[index] == -1){
            return 2;
        }

        if((2 * index + 1) < tree.length && (2 * index + 2) < tree.length){
            int left = dfs(tree, 2 * index + 1);
            int right = dfs(tree, 2 * index + 2);
            if(left == 3 || right == 3){
                res++;
                return 1;
            }
            return left == 1 || right == 1 ? 2 : 3;
        }
        return 0;
    }
}
