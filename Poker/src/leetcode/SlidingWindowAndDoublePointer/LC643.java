package leetcode.SlidingWindowAndDoublePointer;

/** lc 643
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 *
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 *
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 */
public class LC643 {

    public double findMaxAverage(int[] nums, int k) {
        int maxS = Integer.MIN_VALUE;
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            if (i < k - 1) {
                continue;
            }
            maxS = Math.max(maxS, s);
            s -= nums[i - k + 1];
        }
        return (double)maxS / k;
    }

    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        System.out.println(new LC643().findMaxAverage(nums, 4));
    }
}



