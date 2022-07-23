package DP36.coinChange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//硬币找零————贪心失效怎么办（比如总金额11，硬币为3，5两种，这是贪心返回-1，而实际上可以有5，3，3）？贪心失效应该回溯
public class CoinChange2 {
    private int minCoins = Integer.MAX_VALUE;
    public int coinChange(int[] c, int k){
        dfs(k, c, new ArrayList<>());
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }
    private void dfs(int target, int[] c, List<Integer> coins){
        if(target == 0){
            minCoins = Math.min(minCoins, coins.size());
            return;
        }
        for(int i = 0; i < c.length; i++){
            if(target - c[i] < 0) continue;
            coins.add(c[i]);
            dfs(target - c[i], c, coins);
            coins.remove(coins.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] c = {1,2,5};
        System.out.println(new CoinChange2().coinChange(c, 12));
    }
}
