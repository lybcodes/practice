package DP36.jumpGame;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//lc45 BFS 超时
public class JumpGame2 {
    public int jump(int[] nums){
        if(nums.length <= 1) return 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int jumpIndex = q.poll();
                if(jumpIndex == nums.length - 1) return level;
                for(int j = 1; j <= nums[jumpIndex]; j++){
                    q.offer(jumpIndex + j);
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame2().jump(new int[]{2, 3, 1, 1, 4}));
    }
}
