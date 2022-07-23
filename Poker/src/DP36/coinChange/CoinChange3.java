package DP36.coinChange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//硬币找零————利用贪心来优化回溯的时间复杂度（每次从最大面值的硬币开始找，这样的话一旦找到肯定就是硬币数量最少的，不用再往下找了）
public class CoinChange3 {
    private int minCoins = Integer.MAX_VALUE;
    public int coinChange(int[] c, int k){
        Arrays.sort(c);
        dfs(k, c, new ArrayList<>());
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }
    private boolean dfs(int target, int[] c, List<Integer> coins){
        if(target == 0){
            minCoins = Math.min(minCoins, coins.size());
            return true;
        }
        for(int i = c.length - 1; i >= 0; i--){
            if(target - c[i] < 0) continue;
            coins.add(c[i]);
            if(dfs(target - c[i], c, coins)) return true;
            coins.remove(coins.size() - 1);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] c = {1,2,5};
        System.out.println(new CoinChange3().coinChange(c, 12));
    }
}
