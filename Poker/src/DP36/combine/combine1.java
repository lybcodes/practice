package DP36.combine;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.List;
//lc77 任然抽象成树结构 回溯
public class combine1 {
    public List<List<Integer>> combine(int n, int k){
        List<List<Integer>> res = new ArrayList<>();
        if(n < 0 || k < 0 || k > n) return res;
        List<Integer> combination = new ArrayList<>();
        dfs(n, k, 1, combination, res);
        return res;
    }
    private void dfs(int n, int k, int start, List<Integer>combination, List<List<Integer>>res){
        if(combination.size() == k){
            res.add(new ArrayList<>(combination));
            return;
        }
        for(int i = start; i <= n; i++){
            combination.add(i);
            //剪枝 每次递归调用的时候保证子节点大于父节点开始遍历，这样就把相同的和顺序不同的都剔除了
            dfs(n, k, i + 1, combination, res);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new combine1().combine(4, 2));
    }
}
