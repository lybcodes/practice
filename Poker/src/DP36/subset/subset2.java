package DP36.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//lc90 子集（有重复元素）
public class subset2 {
    //如果有重复
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);//排序 去重的基础
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }
    private void dfs(int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> res){
        res.add(new ArrayList<>(subset));//遍历一个节点就加到结果集，所有节点遍历完就推出
        for(int i = startIndex; i < nums.length; i++){
            //剪枝
            if(i > startIndex && nums[i] == nums[i - 1]) continue;
            subset.add(nums[i]);
            dfs(nums, i + 1, subset, res); //i + 1 剪枝 子节点的下标比父节点大
            subset.remove(subset.size() - 1);
        }
    }
}
