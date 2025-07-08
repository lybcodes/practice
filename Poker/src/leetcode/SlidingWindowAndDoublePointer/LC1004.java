package leetcode.SlidingWindowAndDoublePointer;

/** lc 1695
 * 给定一个二进制数组 nums 和一个整数 k，假设最多可以翻转 k 个 0 ，则返回执行操作后 数组中连续 1 的最大个数 。
 *
 * 示例 1：
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 */
public class LC1004 {

    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int l = 0;
        int count = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                count++;
            }
            while (count > k) {
                if (nums[l] == 0) {
                    count--;
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(new LC1004().longestOnes(nums, 2));
    }
}



