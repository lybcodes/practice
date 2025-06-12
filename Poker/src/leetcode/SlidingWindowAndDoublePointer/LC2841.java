package leetcode.SlidingWindowAndDoublePointer;

import java.util.*;

/** lc 2379
 * 给你一个整数数组 nums 和两个正整数 m 和 k 。
 * 请你返回 nums 中长度为 k 的 几乎唯一子数组的最大和，如果不存在几乎唯一子数组，请你返回 0 。
 * 如果 nums 的一个子数组有至少 m 个互不相同的元素，我们称它是 几乎唯一 子数组。
 * 子数组指的是一个数组中一段连续 非空 的元素序列。
 */
public class LC2841 {

    public long maxSum(List<Integer> nums, int m, int k) {
        long sum = 0;
        long maxSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            map.merge(nums.get(i), 1, Integer::sum);
            if (i < k - 1) {
                continue;
            }
            if (map.size() >= m) {
                maxSum = Math.max(maxSum, sum);
            }
            sum -= nums.get(i - k + 1);
            map.merge(nums.get(i - k + 1), -1, Integer::sum);
            if (map.get(nums.get(i - k + 1)) == 0) {
                map.remove(nums.get(i - k + 1));
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2,6,7,3,1,7);
        System.out.println(new LC2841().maxSum(nums, 3, 4));
    }
}
