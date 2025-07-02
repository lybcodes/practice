package leetcode.SlidingWindowAndDoublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/** lc 632
 * 你有 k 个 非递减排列 的整数列表。找到一个 最小 区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
 * 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
 *
 * 示例 1：
 * 输入：nums = [[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 * 输出：[20,24]
 * 解释：
 * 列表 1：[4,10,15,24,26]，24 在区间 [20,24] 中。
 * 列表 2：[0,9,12,20]，20 在区间 [20,24] 中。
 * 列表 3：[5,18,22,30]，22 在区间 [20,24] 中。
 *
 * 示例 2：
 * 输入：nums = [[1,2,3],[1,2,3],[1,2,3]]
 * 输出：[1,1]
 *
 */
public class LC632 {

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int r = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int x = nums.get(i).get(0);
            pq.offer(new int[]{x, i, 0});
            r = Math.max(r, x);
        }
        int ansL = pq.peek()[0];
        int ansR = r;
        while (pq.peek()[2] + 1 < nums.get(pq.peek()[1]).size()) {
            int[] top = pq.poll();
            top[0] = nums.get(top[1]).get(top[2] + 1);
            top[2]++;
            r = Math.max(r, top[0]);
            pq.offer(top);
            int l = pq.peek()[0];
            if (r - l < ansR - ansL) {
                ansL = l;
                ansR = r;
            }
        }
        return new int[]{ansL, ansR};
    }


    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(List.of(4,10,15,24,26));
        nums.add(List.of(0,9,12,20));
        nums.add(List.of(5,18,22,30));
        System.out.println(Arrays.toString(new LC632().smallestRange(nums)));
    }



}



