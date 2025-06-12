package leetcode;

/** lc 3335
 * 给你一个字符串 s 和一个整数 t，表示要执行的 转换 次数。每次 转换 需要根据以下规则替换字符串 s 中的每个字符：
 *
 * 如果字符是 'z'，则将其替换为字符串 "ab"。
 * 否则，将其替换为字母表中的下一个字符。例如，'a' 替换为 'b'，'b' 替换为 'c'，依此类推。
 * 返回 恰好 执行 t 次转换后得到的字符串的 长度。
 *
 * 由于答案可能非常大，返回其对 10^9 + 7 取余的结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入： s = "abcyy", t = 2
 *
 * 输出： 7
 *
 * 解释：
 *
 * 第一次转换 (t = 1)
 * 'a' 变为 'b'
 * 'b' 变为 'c'
 * 'c' 变为 'd'
 * 'y' 变为 'z'
 * 'y' 变为 'z'
 * 第一次转换后的字符串为："bcdzz"
 * 第二次转换 (t = 2)
 * 'b' 变为 'c'
 * 'c' 变为 'd'
 * 'd' 变为 'e'
 * 'z' 变为 "ab"
 * 'z' 变为 "ab"
 * 第二次转换后的字符串为："cdeabab"
 * 最终字符串长度：字符串为 "cdeabab"，长度为 7 个字符。
 * 示例 2：
 *
 * 输入： s = "azbk", t = 1
 *
 * 输出： 5
 *
 * 解释：
 *
 * 第一次转换 (t = 1)
 * 'a' 变为 'b'
 * 'z' 变为 "ab"
 * 'b' 变为 'c'
 * 'k' 变为 'l'
 * 第一次转换后的字符串为："babcl"
 * 最终字符串长度：字符串为 "babcl"，长度为 5 个字符。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * s 仅由小写英文字母组成。
 * 1 <= t <= 105
 */
public class LC3335 {
    private static final int MOD = 1000000007;

    /**
     * 递推 f[i][c]表示经过第i次转换，字符串包含c的数量，c的取值范围是[0,26)，依次对应从a到z的26个字符
     * 状态转移方程：
     * c = 0 时， f[i][c] = f[i-1][25] 对应 a 从 z 转换而来
     * c = 1 时， f[i][c] = f[i-1][25] + f[i-1][0]  对应  b 从 z 转换而来或者从 a 转换而来
     * c >= 2 时，f[i][c] = f[i-1][c-1]
     * 最终结果为 f[t][0] + f[t][1] + ... + f[t][26]
     */
    public int getLengthAfterTransformations(String s, int t) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            ++cnt[c - 'a'];
        }
        for (int round = 0; round < t; round++) {
            int[] next = new int[26];
            next[0] = cnt[25];
            next[1] = cnt[25] + cnt[0];
            for (int i = 2; i < 26; i++) {
                next[i] = cnt[i - 1];
            }
            cnt = next;
        }
        int res = 0;
        for(int i = 0; i < 26; i++) {
            res = (res + cnt[i]) % MOD;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcyy";
        int t = 2;
        System.out.println(new LC3335().getLengthAfterTransformations(s, t));
    }
}
