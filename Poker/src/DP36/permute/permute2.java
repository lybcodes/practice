package DP36.permute;

import java.util.ArrayList;
import java.util.List;

//回溯 本质上是深度优先遍历
//回溯 一般把问题抽象称一棵树 然后穷举所有情况
//回溯代码框架 + 剪枝
//记忆化搜索优化时间复杂度——lc46
public class permute2 {
    private boolean[] used; //替换contains 降低时间复杂度
    public List<List<Integer>> permute(int[] nums){ //总时间复杂度降为O(n*n!)
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        used = new boolean[nums.length];
        dfs(nums, path, res);   //这里根节点调用一次dfs
        return res;
    }
    private void dfs(int[] nums,
                     List<Integer> path,
                     List<List<Integer>> res){  //一次dfs总的时间复杂度是O(n^2)
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){ //这里一次for循环 O(n)
            //剪枝 判断重复数字
            //if(path.contains(nums[i])) continue; //这里一次contains O(n)
            if(used[i]) continue; //这里时间复杂度就降为 O(1)
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, path, res);  //
            //回溯的过程中 将当前节点从 path 中删除
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new permute2().permute(new int[]{1,2,3}));
    }
}
