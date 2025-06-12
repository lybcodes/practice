package leetcode.SlidingWindowAndDoublePointer;

import java.util.Arrays;

/** lc 1652
 *你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为 n 的 循环 数组 code 以及一个密钥 k 。
 * 为了获得正确的密码，你需要替换掉每一个数字。所有数字会 同时 被替换。
 * 如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换。
 * 如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
 * 如果 k == 0 ，将第 i 个数字用 0 替换。
 * 由于 code 是循环的， code[n-1] 下一个元素是 code[0] ，且 code[0] 前一个元素是 code[n-1] 。
 * 给你 循环 数组 code 和整数密钥 k ，请你返回解密后的结果来拆除炸弹！
 *
 * 示例 1：
 * 如果 k>0，例如 code=[3,1,4,1,5,9]，k=3：
 * 计算 ans[0]，即子数组 [1,4,1] 的元素和 1+4+1=6。
 * 计算 ans[1]，即子数组 [4,1,5] 的元素和，我们可以在 [1,4,1] 的基础上，增加 code[4]=5，减少 code[1]=1，得到 6+5−1=10。
 * 计算 ans[2]，即子数组 [1,5,9] 的元素和，我们可以在 [4,1,5] 的基础上，增加 code[5]=9，减少 code[2]=4，得到 10+9−4=15。
 * 计算 ans[3]，即子数组 [5,9,3] 的元素和，我们可以在 [1,5,9] 的基础上，增加 code[6mod6]=code[0]=3，减少 code[3]=1，得到 15+3−1=17。
 * 计算 ans[4]，即子数组 [9,3,1] 的元素和，我们可以在 [5,9,3] 的基础上，增加 code[7mod6]=code[1]=1，减少 code[4]=5，得到 17+1−5=13。
 * 计算 ans[5]，即子数组 [3,1,4] 的元素和，我们可以在 [9,3,1] 的基础上，增加 code[8mod6]=code[2]=4，减少 code[5]=9，得到 13+4−9=8。
 * 对于 k<0 的情况也同理。注意无论 k>0 还是 k<0，窗口都在向右移动，只有初始位置不同。所以确定好第一个窗口的位置，就可以把 k>0 和 k<0 两种情况合并起来了：
 *
 * k>0，第一个窗口的的下标范围为 [1,k+1)。
 * k<0，第一个窗口的的下标范围为 [n−∣k∣,n)。
 * 无论 k 是正是负，窗口的大小都是 ∣k∣。
 * 在窗口向右滑动时，设移入窗口的元素下标为 r mod n，则移出窗口的元素下标为 (r−∣k∣) mod n。
 */
public class LC1652 {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int s = 0;
        int[] ans = new int[n];
        int r = k > 0 ? k + 1 : n; //第一个窗口的右边界
        k = Math.abs(k);
        for (int i = r - k; i < r; i++) {
            s += code[i]; // 计算 ans[0]
        }
        // 开始向右滑动窗口
        for (int i = 0; i < n; i++) {
            ans[i] = s;
            s += code[r % n] - code[(r - k) % n];
            r++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] code = new int[]{5,7,1,4};
        System.out.println(Arrays.toString(new LC1652().decrypt(code,3)));
    }
}
