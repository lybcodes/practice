package DP36.jumpGame;

import java.util.ArrayList;
import java.util.List;
//lc45 DFS 超时
public class JumpGame1 {
    private int minSteps = Integer.MAX_VALUE;
    public int jump(int[] nums){
        dfs(nums, 0, new ArrayList<>());
        return minSteps == Integer.MAX_VALUE ? 0 : minSteps;
    }
    private void dfs(int[] nums, int jumpIndex, List<Integer> path){
        if(jumpIndex == nums.length - 1){
            minSteps = Math.min(minSteps, path.size());
            return;
        }
        for(int i = 1; i <= nums[jumpIndex]; i++){
            if(jumpIndex + i > nums.length) continue;
            path.add(i);
            dfs(nums, jumpIndex + i, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame1().jump(new int[]{2, 3, 1, 1, 4}));
    }
}
