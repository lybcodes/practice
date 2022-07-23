package PDD;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    public static int cutBat(int m, int n){
        return cutBar(m, n, 1);
    }
    public static int cutBar(int m, int n, int k){
        if(k >= n){
            return 0;//当k大于等于需要切分的棍子的个数，就不需要再切分了
        }
        return cutBar(m, n, k + Math.min(k, m)) + 1;
    }

    public static void main(String[] args) {
        System.out.println(cutBat(5, 100));
    }
}
