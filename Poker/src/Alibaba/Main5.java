package Alibaba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
//        String[] numbers = sc.nextLine().trim().split(" ");
//        for(int i = 0; i < numbers.length; i++){
//            list.add(Integer.parseInt(numbers[i]));
//        }
        while(sc.hasNextInt()){
            list.add(sc.nextInt());
        }
        if(list.size() == 1) System.out.println(list.get(0));
        int[] dp = new int[list.size()];
        dp[0] = list.get(0);
        dp[1] = Math.max(list.get(0), list.get(1));
        for(int i = 2; i < list.size();i++){
            dp[i] = Math.max(dp[i - 2] + list.get(i), dp[i - 1]);
        }
        System.out.println(dp[list.size() - 1]);
    }
}
