package leetcode.SlidingWindowAndDoublePointer;

import java.util.HashMap;
import java.util.Map;

/** lc 904
 * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组fruits表示，其中fruits[i]是第i棵树上的水果种类。
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
 * 你只有两个篮子，并且每个篮子只能装单一类型的水果。每个篮子能够装的水果总量没有限制。
 * 你可以选择任意一棵树开始采摘，你必须从 每棵树（包括开始采摘的树）上恰好摘一个水果 。
 * 采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
 * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 * 给你一个整数数组 fruits ，返回你可以收集的水果的最大数目。
 *
 * 示例 1：
 * 输入：fruits = [1,2,1]
 * 输出：3
 * 解释：可以采摘全部 3 棵树。
 *
 * 示例 3：
 * 输入：fruits = [1,2,3,2,2]
 * 输出：4
 * 解释：可以采摘 [2,3,2,2] 这四棵树。
 * 如果从第一棵树开始采摘，则只能采摘 [1,2] 这两棵树。
 */
public class LC904 {

    public int totalFruit(int[] fruits) {
        // 找出最长连续子数组，这个子数组中只包含两个不同元素
        int ans = 0;
        int l = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int r = 0; r < fruits.length; r++) {
            map.merge(fruits[r], 1, Integer::sum);
            while (map.size() > 2) {
                int out = fruits[l];
                map.merge(out, -1, Integer::sum);
                if (map.get(out) == 0) {
                    map.remove(out);
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,2,2};
        System.out.println(4 == new LC904().totalFruit(nums));
    }
}



