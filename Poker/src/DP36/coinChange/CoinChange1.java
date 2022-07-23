package DP36.coinChange;

import java.util.Arrays;

//硬币找零————贪心算法
public class CoinChange1 {
    public int coinChange(int[] c, int k){
        Arrays.sort(c);
        int rest = k;
        int res = 0;
        for(int i = c.length - 1; i >= 0; i--){
            int curCount = rest / c[i]; //需要当前面值多少个
            rest = rest - curCount * c[i]; //还剩多少钱
            res += curCount;
            if(rest == 0){
                return res;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] c = {1,2,5};
        System.out.println(new CoinChange1().coinChange(c, 12));
    }
}
