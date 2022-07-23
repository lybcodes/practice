package DP36.jumpGame;

import java.util.ArrayDeque;
import java.util.Queue;

//lc45 贪心（就是遍历了一遍数组，时间复杂度O(N)）
public class JumpGame3 {
    public int jump(int[] nums){
        if(nums.length <= 1) return 0;
        int step = 0;
        int start = 0, end = 0;
        while(end < nums.length - 1){
            int maxPos = 0;
            for(int i = start; i <= end; i++){
                maxPos = Math.max(maxPos, i + nums[i]);
            }
            start = end + 1;
            end = maxPos;
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame3().jump(new int[]{2, 3, 1, 1, 4}));
    }
}
