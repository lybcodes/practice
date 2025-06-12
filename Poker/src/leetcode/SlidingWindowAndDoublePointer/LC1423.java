package leetcode.SlidingWindowAndDoublePointer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/** lc 2461
 * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
 * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
 * 你的点数就是你拿到手中的所有卡牌的点数之和。
 * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
 */
public class LC1423 {

    public int maxScore(int[] cardPoints, int k) {
        // 转变为长度n-k的固定滑动窗口
        int s = 0;
        int n = cardPoints.length;
        for (int i = 0; i < n - k; i++) {
            s += cardPoints[i];
        }
        int totalSum = s;
        int ans = s;
        for (int i = n - k; i < n; i++) {
            totalSum += cardPoints[i];
            s += cardPoints[i] - cardPoints[i - (n - k)];
            ans = Math.min(ans, s);
        }
        return totalSum - ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,1};
        System.out.println(12 == new LC1423().maxScore(nums, 3));
    }
}
