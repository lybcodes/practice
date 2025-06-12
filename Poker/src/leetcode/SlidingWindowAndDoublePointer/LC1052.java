package leetcode.SlidingWindowAndDoublePointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** lc 1052
 * 有一个书店老板，他的书店开了 n 分钟。每分钟都有一些顾客进入这家商店。给定一个长度为 n 的整数数组 customers ，
 * 其中 customers[i] 是在第 i 分钟开始时进入商店的顾客数量，所有这些顾客在第 i 分钟结束后离开。
 * 在某些分钟内，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
 * 当书店老板生气时，那一分钟的顾客就会不满意，若老板不生气则顾客是满意的。
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 minutes 分钟不生气，但却只能使用一次。
 * 请你返回 这一天营业下来，最多有多少客户能够感到满意。
 * 示例 1：
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy =[0,1,0,1,0,1,0,1] minutes = 3
 * 输出：16
 * 解释：书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 */
public class LC1052 {
    // 1、先找出所有不生气时的顾客，求和 s0
    // 2、长度为minutes的滑动窗口内找出生气时的顾客数量之和的最大值 maxS1
    // 3、最终结果 s0 + maxS1
    public long maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int maxS1 = 0;
        int[] s = new int[2];
        for (int i = 0; i < customers.length; i++) {
            s[grumpy[i]] += customers[i];//s[0]是满意数量之和，s[1]是不满意数量之和
            if (i < minutes - 1) {
                continue;
            }
            maxS1 = Math.max(maxS1, s[1]);
            s[1] -= grumpy[i - minutes + 1] > 0 ? customers[i - minutes + 1] : 0;
        }
        return s[0] + maxS1;
    }

    public static void main(String[] args) {
        int[] customers = new int[]{1,0,1,2,1,1,7,5};
        int[] grumpy = new int[]{0,1,0,1,0,1,0,1};
        System.out.println(16 == new LC1052().maxSatisfied(customers, grumpy, 3));
    }
}
