package tencent;

import java.util.Scanner;

public class num1 {
    private int minCount(int n){
        int count = 0;
        while(n > 0){
            if(n % 3 == 0){
                n = n / 3;
                count++;
            }else if(n % 2 == 0){
                n = n / 2;
                count++;
            }else{
                n--;
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int n = 0;
        while(T-- >0){
            n = sc.nextInt();
            System.out.println(new num1().minCount(n));
        }

    }
}
