package leetcode.SlidingWindowAndDoublePointer;

/** lc 76
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 *
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 *
 * 示例 3:
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符dd   d串。
 */
public class LC76 {

    public String minWindow(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int[] cntT = new int[128];
        for (char c : chart) {
            cntT[c]++;
        }
        int n = chars.length;
        int left = 0;
        int ansL = -1, ansR = n;
        int[] cntS = new int[128];
        for (int right = 0; right < n; right++) {
            cntS[chars[right]]++;
            while (isCover(cntS, cntT)) {
                if (right - left < ansR - ansL) {
                    ansL = left;
                    ansR = right;
                }
                cntS[chars[left]]--;
                left++;
            }
        }
        return ansL < 0 ? "" : s.substring(ansL, ansR + 1);
    }

    private boolean isCover(int[] cntS, int[] cntT) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        System.out.println("BANC".equals(new LC76().minWindow(s,"ABC")));
    }
}



