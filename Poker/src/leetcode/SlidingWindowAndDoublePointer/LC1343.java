package leetcode.SlidingWindowAndDoublePointer;

/** lc 1343
 * 给你一个整数数组 arr 和两个整数 k 和 threshold 。
 * 请你返回长度为 k 且平均值大于等于 threshold 的子数组数目。
 */
public class LC1343 {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i < k - 1) {
                continue;
            }
            if (sum / k >= threshold) {
                ans++;
            }
            sum -= arr[i - k + 1];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {11,13,17,23,29,31,7,5,2,3};
        System.out.println(new LC1343().numOfSubarrays(nums, 3,5));
    }
}
