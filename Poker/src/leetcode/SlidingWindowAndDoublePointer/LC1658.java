package leetcode.SlidingWindowAndDoublePointer;

/** lc 1658
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。
 * 请注意，需要 修改 数组以供接下来的操作使用。
 * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 *
 * 示例 1：
 * 输入：nums = [1,1,4,2,3], x = 5
 * 输出：2
 * 解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
 *
 * 示例 2：
 * 输入：nums = [5,6,7,8,9], x = 4
 * 输出：-1
 *
 * 示例 3：
 * 输入：nums = [3,2,20,1,1,3], x = 10
 * 输出：5
 * 解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
 */
public class LC1658 {

    public int minOperations(int[] nums, int x) {
        // 寻找最长子数组和为 sum - x
        int target = -x;
        for (int v : nums) {
            target += v;
        }
        if (target < 0) {
            return -1;
        }
        int ans = -1;
        int l = 0;
        int sum  = 0;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum > target) {
                sum -= nums[l];
                l++;
            }
            if (sum == target) {
                ans = Math.max(ans, r - l + 1);
            }
        }
        return ans < 0 ? -1 : nums.length - ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,20,1,1,3};
        System.out.println(new LC1658().minOperations(nums, 10));
    }
}



