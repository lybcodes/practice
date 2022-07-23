package Alibaba;

import java.util.Scanner;

/**
 * 小强是一个农场主，农场里有n头牛，每头牛有着独一无二的体重，每一头牛的颜色可能跟是m种颜色其中的一种，
 * 小强带了一些牛（可能为0个）出来吃草。你需要回答出小强带出来的牛的组合一共有多少种可能？
 *
 * 注意：因为一头牛有自己的体重（没有两头牛体重相等），
 * 所以如果四头牛的体重分别是1,2,3,4，颜色分别是y1,y2,y3,y4和另一种方案：
 * 四头牛的体重分别是1,2,3,4颜色分别是y1,y3,y2,y4即使两个方案的颜色的种类对应的数量是相同的，
 * 但是因为颜色对应的体重不同，所以是两个不同的方案。
 * 由于方案书可能很大，请对1e9+7取模。
 *
 * 输入描述：
 * 两个整数n,m(1≤n,m≤10^9)
 * 输入： 3,2
 *
 * 输出： 27
 *
 * 思路：排列组合
 *       0头牛-C(N,0)
 *       1头牛-C(N,1)*M
 *       2头牛-C(N,2)*M^2
 *       .
 *       .
 *       .
 *       N头牛-C(N,N)*M^N
 *       加起来就是(m+1)^n
 */

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();
            int m = in.nextInt();
            System.out.println(dfs(m + 1, n));//带出来0头牛也算一种，所以是m+1
        }
    }
    public static long dfs(int m, int n){
        if(n == 1){
            return (long)m;
        }
        long l = dfs(m, n / 2);
        return ((n % 2 == 0 ? 1 : m) * l * l) % 1000000007;
    }
}
