package leetcode.SlidingWindowAndDoublePointer;

/** lc 3335
 * 给你字符串 s 和整数 k 。
 *
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 *
 * 英文中的 元音字母 为（a, e, i, o, u）。
 */
public class LC1456 {

    public int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();
        int ans = 0;
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            // 1、进入窗口
            if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') {
                count++;
            }
            if (i < k - 1) { // 窗口大小不足 k,窗口未完全进入
                continue;
            }
            // 2、更新答案
            ans = Math.max(ans, count);
            // 3、移出窗口
            char out = chars[i -k + 1];
            if (out == 'a' || out == 'e' || out == 'i' || out == 'o' || out == 'u') {
                count--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "rhythms";
        System.out.println(new LC1456().maxVowels(s, 4));
    }
}
