package leetcode.SlidingWindowAndDoublePointer;

import java.util.HashMap;
import java.util.Map;

/** lc 3
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 */
public class LC3 {

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int ans = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < chars.length; right++) {
            char c = chars[right];
            map.merge(c, 1, Integer::sum);
            while (map.get(c) > 1) {
                map.merge(chars[left], -1, Integer::sum);
                if (map.get(chars[left]) == 0) {
                    map.remove(chars[left]);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(3 == new LC3().lengthOfLongestSubstring(s));
    }
}



