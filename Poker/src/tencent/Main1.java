package tencent;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            cnt += subStringCnt(s, i);
        }
        System.out.println(cnt);
    }
    public static int subStringCnt(String s, int start){
        int cnt = 0, sum = 0;
        for(int i = start; i < s.length(); i++){
            sum += s.charAt(i) - '0';
            if(sum % 22 == 0){
                cnt++;
            }
            sum *= 10;
            sum /= 22;
        }
        return cnt;
    }
}
