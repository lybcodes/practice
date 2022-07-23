package DP36.permute;

import java.util.ArrayList;
import java.util.List;

//回溯 本质上是深度优先遍历
//回溯 一般把问题抽象称一棵树 然后穷举所有情况
//回溯代码框架
public class lc46and47 {
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, -1, path, res);
        return res;
    }
    private void dfs(int[] nums, int index,
                     List<Integer> path,
                     List<List<Integer>> res){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            path.add(nums[i]);
            dfs(nums, i, path, res);
            //回溯的过程中 将当前节点从 path 中删除
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new lc46and47().permute(new int[]{1,2,3}));
    }
}
