package DP36.coinChange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//硬币找零————动态规划 从下往上（在遍历每个节点的时候返回这个）
public class CoinChange4 {
    public int coinChange(int[] c, int k){
        if(k < 0) return -1;
        if(k == 0) return 0;

        //1、状态定义：dp[i] 表示金额为i时需要的最小硬币数
        int[] dp = new int[k + 1];

        //2、状态初始化
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        //3、状态转移
        for(int target = 1; target <= k; target++){
            for(int coin : c){
                if(target >= coin && dp[target - coin] != Integer.MAX_VALUE){
                    dp[target] = Math.min(dp[target], dp[target - coin] + 1);
                }
            }
        }

        //4、返回最终的状态值
        return dp[k] == Integer.MAX_VALUE ? -1 : dp[k];
    }

    public static void main(String[] args) {
        int[] c = {1,2,5};
        System.out.println(new CoinChange4().coinChange(c, 12));
    }
}
