package leetcode.SlidingWindowAndDoublePointer;

import java.util.Arrays;

/** lc 2379
 * 给你一个长度为 n 下标从 0 开始的字符串 blocks ，blocks[i] 要么是 'W' 要么是 'B' ，表示第 i 块的颜色。字符 'W' 和 'B' 分别表示白色和黑色。
 * 给你一个整数 k ，表示想要 连续 黑色块的数目。
 * 每一次操作中，你可以选择一个白色块将它 涂成 黑色块。
 * 请你返回至少出现 一次 连续 k 个黑色块的 最少 操作次数。
 */
public class LC2379 {

    public int minimumRecolors(String blocks, int k) {
        // 其实就是计算连续k个子串中白色块最少个数
        char[] s = blocks.toCharArray();
        int ans = Integer.MAX_VALUE;
        int whiteCount = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == 'W') {
                whiteCount++;
            }
            if (i < k - 1) {
                continue;
            }
            ans = Math.min(ans, whiteCount);
            char out = s[i - k + 1];
            if (out == 'W') {
                whiteCount--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "WBBWWBBWBW";
        System.out.println(new LC2379().minimumRecolors(s, 7));
    }
}
