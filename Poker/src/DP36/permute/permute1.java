package DP36.permute;

import java.util.ArrayList;
import java.util.List;

//回溯 本质上是深度优先遍历
//回溯 一般把问题抽象称一棵树 然后穷举所有情况
//回溯代码框架 + 剪枝
public class permute1 {
    public List<List<Integer>> permute(int[] nums){
        //一次dfs的时间复杂度是O(n^2)，总共递归了n!个节点，也即递归调用了n!次，故总时间复杂度O(n^2*n!)
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
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
            if(path.contains(nums[i])) continue; //这里一次contains O(n)
            path.add(nums[i]);
            dfs(nums, path, res);  //
            //回溯的过程中 将当前节点从 path 中删除
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new permute1().permute(new int[]{1,2,3}));
    }
}
