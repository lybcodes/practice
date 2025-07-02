package leetcode.SlidingWindowAndDoublePointer;

import java.util.HashMap;
import java.util.Map;

/** lc 1695
 * 给你一个正整数数组 nums ，请你从中删除一个含有若干不同元素的子数组。删除子数组的得分就是子数组各元素之和 。
 * 返回只删除一个子数组可获得的 最大得分 。
 * 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
 *
 * 示例 1：
 * 输入：nums = [4,2,4,5,6]
 * 输出：17
 * 解释：最优子数组是 [2,4,5,6]
 * 示例 2：
 * 输入：nums = [5,2,1,2,5,2,1,2,5]
 * 输出：8
 * 解释：最优子数组是 [5,2,1] 或 [1,2,5]
 */
public class LC1695 {

    public int maximumUniqueSubarray(int[] nums) {
        //找到元素和最大的子数组，且子数组不包含重复元素
        int ans = 0;
        int l = 0;
        int maxS = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int r = 0; r < nums.length; r++) {
            maxS += nums[r];
            map.merge(nums[r], 1, Integer::sum);
            while (map.get(nums[r]) > 1) {
                int out = nums[l];
                map.merge(out, -1, Integer::sum);
                if (map.get(out) == 0) {
                    map.remove(out);
                }
                maxS -= nums[l];
                l++;
            }
            ans = Math.max(ans, maxS);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,4,5,6};
        System.out.println(new LC1695().maximumUniqueSubarray(nums));
    }
}



