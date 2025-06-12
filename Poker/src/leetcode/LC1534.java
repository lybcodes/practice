package leetcode;

/** lc 3335
 * 给你一个整数数组 arr ，以及 a、b 、c 三个整数。请你统计其中好三元组的数量。
 *
 * 如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件，则认为它是一个 好三元组 。
 *
 * 0 <= i < j < k < arr.length
 * |arr[i] - arr[j]| <= a
 * |arr[j] - arr[k]| <= b
 * |arr[i] - arr[k]| <= c
 * 其中 |x| 表示 x 的绝对值。
 *
 * 返回 好三元组的数量 。
 */
public class LC1534 {

    private int countGoodTriplets(int [] arr, int a, int b, int c) {
        int mx = 0;
        for (int x : arr) {
            mx = Math.max(mx, x);
        }

        int[] s = new int[mx + 2];
        int ans = 0;
        for (int j = 0; j < arr.length; j++) {
            int y = arr[j];
            for(int k = j + 1; k < arr.length; k++) {
                int z = arr[k];
                if (Math.abs(y - z) > b) {
                    continue;
                }
                int l = Math.max(Math.max(y - a, z - c), 0);
                int r = Math.min(Math.min(y + a, z + c), mx);
                ans += Math.max(s[r + 1] - s[l], 0);
            }
            for (int v = y + 1; v < s.length; v++) {
                s[v]++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3,0,1,1,9,7};
        String s = "AA";
        System.out.println(new LC1534().countGoodTriplets(arr, 7, 2, 3));
    }
}
