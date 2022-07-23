package DP36.permute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//回溯 本质上是深度优先遍历
//回溯 一般把问题抽象称一棵树 然后穷举所有情况
//回溯代码框架 + 剪枝
//全排列如果有重复的数字——lc47
public class permute3 {
    private boolean[] used; //替换contains 降低时间复杂度
    public List<List<Integer>> permute(int[] nums){ //总时间复杂度降为O(n*n!)   
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        used = new boolean[nums.length];
        Arrays.sort(nums);//排序是去重的基础
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
            //去重剪枝（当前值等于前一个值，并且前一个值已经遍历过了）
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            path.add(nums[i]);
            used[i] = true;
            //如果没有path.remove(path.size() - 1);的话就要重新创建一个
            //   List<Integer> list = new ArrayList<>(path);
            //list.add(nums[i]);
            // 这是由于在java中List是引用传递，会造成递归分支污染，所以这里要重新创建一个
            dfs(nums, path, res);  
            //如果不想重建的话，那么在回溯的过程中 将当前节点从 path 中删除，
            //回到当前节点的时候我们把当前节点给移除,
            // 然后通过循环走同一层的其他节点。
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new permute3().permute(new int[]{1,1,2}));
    }
}
