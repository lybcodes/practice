package leetcode.SlidingWindowAndDoublePointer;

import java.util.HashMap;
import java.util.Map;

/** lc 3
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 * 如果不存在这样的子数组，请返回 0 。
 */
public class LC1493 {

    public int longestSubarray(int[] nums) {
        //滑动窗口思路：因为删掉一个元素，那肯定是删掉0，所以将所求看作是只包含一个0的最长子数组，最后再减1即可
        int ans = 0;
        int left = 0;
        int[] record = new int[2];
        for (int right = 0; right < nums.length; right++) {
            record[nums[ right]]++;
            while(record[0] > 1) {
                record[nums[left]]--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans - 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,0,1};
        System.out.println(3 == new LC1493().longestSubarray(nums));
    }
}



