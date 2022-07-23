package meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 判断一个字符串中能有多少被22整除的子串
 */

public class Main {
    public static void main(String[] args) {
        /**
         * 题解：
         * https://blog.csdn.net/weixin_43872728/article/details/105779079?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-8.no_search_link&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-8.no_search_link
         *
         * 从字符串右端向左拓展整数，如果出现两个数的余数相同就说明这两个数之间存在2019的倍数；所以用一个数组或者map记录之前每个余数出现的次数，每个x与之前同余的数间都可以构成2019的倍数，如果余数为0则x本身就可以作为2019的倍数,所以map[0]初始化为1。
         */
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int ans = 0;
        int cnt = 0;
        int[] mp = new int[1000];
        mp[0] = 1;
        int p = 1;
        for(int i = s.length() - 1; i >= 0; i--){
            ans = (ans + (s.charAt(i) - '0') * p) % 22;
            cnt += mp[ans]++;
            p = p * 10 % 22;//注意这里是上面对ans取模的时候也对p进行了取模(针对字符串特别大的情况)
        }
        System.out.println(cnt);
    }
}
