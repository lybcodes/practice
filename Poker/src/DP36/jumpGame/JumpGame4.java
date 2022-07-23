package DP36.jumpGame;

//lc45 贪心（就是遍历了一遍数组，时间复杂度O(N)）
//优化为一次循环，因为它只遍历了一遍数组
public class JumpGame4 {
    public int jump(int[] nums){
        if(nums.length <= 1) return 0;
        int step = 0;
        int maxPos = 0, end = 0;
        for(int i = 0; i < nums.length - 1; i++){
            maxPos = Math.max(maxPos, i + nums[i]);
            if(i == end){
                step++;
                end = maxPos;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame4().jump(new int[]{2, 3, 1, 1, 4}));
    }
}
