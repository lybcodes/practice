package DP36.removeKdigits;

import java.util.ArrayDeque;
import java.util.Deque;

//lc402 贪心 + 单调栈
public class removeKdigits1 {
    public String removeKdigits(String num, int k){
        Deque<Character> deque = new ArrayDeque<>();
        for(int i = 0; i < num.length(); i++){
            char c = num.charAt(i);
            while(!deque.isEmpty() && k > 0 && c < deque.peekFirst()){
                deque.pollFirst();
                k--;
            }
            deque.addFirst(c);
        }
        for(int i = 0; i < k; i++){
            deque.pollFirst();
        }
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            sb.append(deque.pollLast());
        }
        int len = sb.length();
        while(len != 0){
            if(sb.charAt(0) > '0') break;
            sb.deleteCharAt(0);
            len = sb.length();
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
