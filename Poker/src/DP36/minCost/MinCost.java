package DP36.minCost;

//lc1578 贪心（双指针实现）
public class MinCost {
    public int minCost(String s, int[] cost){
        int res = 0;
        int i = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            int maxCost = 0;
            int sumCost = 0;
            while(i < s.length() && s.charAt(i) == c){
                maxCost = Math.max(maxCost, cost[i]);
                sumCost = sumCost + cost[i];
            }
            res += (sumCost - maxCost);
        }
        return res;
    }
}
