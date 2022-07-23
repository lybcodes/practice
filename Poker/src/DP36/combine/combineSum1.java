package DP36.combine;

import java.util.ArrayList;
import java.util.List;

//lc39 组合总数
public class combineSum1 {
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
            combination.add(nums[i]);
            dfs(nums, target - nums[i], i, combination, res);
            combination.remove(combination.size() - 1);
        }
    }
}
