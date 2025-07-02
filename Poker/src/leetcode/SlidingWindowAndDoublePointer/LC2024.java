package leetcode.SlidingWindowAndDoublePointer;

import java.util.HashMap;
import java.util.Map;

/** lc 1695
 * 一位老师正在出一场由 n 道判断题构成的考试，每道题的答案为 true （用 'T' 表示）或者 false （用 'F' 表示）。
 * 老师想增加学生对自己做出答案的不确定性，方法是 最大化 有 连续相同 结果的题数。（也就是连续出现 true 或者连续出现 false）。
 * 给你一个字符串 answerKey ，其中 answerKey[i] 是第 i 个问题的正确结果。
 * 除此以外，还给你一个整数 k ，表示你能进行以下操作的最多次数：
 * 每次操作中，将问题的正确答案改为 'T' 或者 'F' （也就是将 answerKey[i] 改为 'T' 或者 'F' ）。
 * 请你返回在不超过 k 次操作的情况下，最大 连续 'T' 或者 'F' 的数目。
 *
 * 示例：
 * 输入：answerKey = "TTFF", k = 2
 * 输出：4
 * 解释：我们可以将两个 'F' 都变为 'T' ，得到 answerKey = "TTTT" 。
 * 总共有四个连续的 'T' 。
 */
public class LC2024 {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxConsecutiveAnswersChar(answerKey, k, 'T'), maxConsecutiveAnswersChar(answerKey, k, 'F'));
    }

    private int maxConsecutiveAnswersChar(String answerKey, int k, char givenChar) {
        char[] s = answerKey.toCharArray();
        int ans = 0;
        int l = 0;
        int sum = 0;
        for (int r = 0; r < s.length; r++) {
            char ch = s[r];
            if (ch != givenChar) {
                sum++;
            }
            while (sum > k) {
                char out = s[l];
                if (out != givenChar) {
                    sum--;
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "TFFT";
        System.out.println(new LC2024().maxConsecutiveAnswers(s, 1));
    }
}



