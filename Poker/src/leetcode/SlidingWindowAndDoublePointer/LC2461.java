package leetcode.SlidingWindowAndDoublePointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** lc 2461
 * 给你一个整数数组 nums 和一个整数 k 。请你从 nums 中满足下述条件的全部子数组中找出最大子数组和：
 * 子数组的长度是 k，且
 * 子数组中的所有元素 各不相同 。
 * 返回满足题面要求的最大子数组和。如果不存在子数组满足这些条件，返回 0 。
 */
public class LC2461 {

    public long maximumSubarraySum(int[] nums, int k) {
        long s = 0;
        long maxS = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            map.merge(nums[i], 1, Integer::sum);
            if (i < k - 1) {
                continue;
            }
            if (map.size() == k) {
                maxS = Math.max(maxS, s);
            }
            s -= nums[i - k + 1];
            map.merge(nums[i - k + 1], -1, Integer::sum);
            if (map.get(nums[i - k + 1]) == 0) {
                map.remove(nums[i - k + 1]);
            }
        }
        return maxS;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,4,2,9,9,9};
        System.out.println(new LC2461().maximumSubarraySum(nums, 3));
    }
}
