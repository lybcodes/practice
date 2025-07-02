package leetcode.SlidingWindowAndDoublePointer;

import java.util.HashMap;
import java.util.Map;

/** lc 1695
 * 给你一个整数数组 nums 和一个整数 k 。
 * 一个元素 x 在数组中的 频率 指的是它在数组中的出现次数。
 * 如果一个数组中所有元素的频率都 小于等于 k ，那么我们称这个数组是 好 数组。
 * 请你返回 nums 中最长好子数组的长度。
 * 子数组 指的是一个数组中一段连续非空的元素序列。
 *
 * 示例：
 * 输入：nums = [1,2,3,1,2,3,1,2], k = 2
 * 输出：6
 * 解释：最长好子数组是 [1,2,3,1,2,3] ，值 1 ，2 和 3 在子数组中的频率都没有超过 k = 2 。[2,3,1,2,3,1] 和 [3,1,2,3,1,2] 也是好子数组。
 * 最长好子数组的长度为 6 。
 */
public class LC2958 {

    public int maxSubarrayLength(int[] nums, int k) {
        int ans = 0;
        int l = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int r = 0; r < nums.length; r++) {
            map.merge(nums[r], 1, Integer::sum);
            while (map.get(nums[r]) > k) {
                int out = nums[l];
                map.merge(out, -1, Integer::sum);
                if (map.get(out) == 0) {
                    map.remove(out);
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1,2,3,1,2};
        System.out.println(new LC2958().maxSubarrayLength(nums, 2));
    }
}



