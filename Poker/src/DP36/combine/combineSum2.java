package DP36.combine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//lc40 组合总数变形 有重复数字 每个数只能用一次
public class combineSum2 {
    public List<List<Integer>> combinationSum1(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        dfs(nums, target, 0, combination, res);
        return res;
    }
    private void dfs(int[] nums, int target, int startIndex, List<Integer> combination, List<List<Integer>> res){
        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<>(combination));
            return;
        }
        for(int i = startIndex; i < nums.length; i++){
            if(i > startIndex && nums[i] == nums[i - 1]) continue;
            combination.add(nums[i]);
            dfs(nums, target - nums[i], i + 1, combination, res);
            combination.remove(combination.size() - 1);
        }
    }
}
