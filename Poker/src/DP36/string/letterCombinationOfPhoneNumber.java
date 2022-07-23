package DP36.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//lc17 电话号码组合
public class letterCombinationOfPhoneNumber {
    private Map<Character, String> phone = new HashMap<Character, String>(){{
       put('2', "abc");
       put('3', "def");
       put('4', "ghi");
       put('5', "jkl");
       put('6', "mno");
       put('7', "pqrs");
       put('8', "tuv");
       put('9', "wxyz");
    }};

    //输入一个数字字符串“234”
    public List<String> letterCombinations(String digits){
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0)
            return res;
        dfs(digits, 0, res, new StringBuilder());
        return res;
    }
    private void dfs(String digits, int index, List<String> res, StringBuilder sb){
        if(index == digits.length()){
            res.add(sb.toString());
            return;
        }
        char numChar = digits.charAt(index);
        char[] letters = phone.get(numChar).toCharArray();
        for(char c : letters){
            sb.append(c);
            dfs(digits, index + 1, res, sb);
            sb.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        System.out.println(new letterCombinationOfPhoneNumber().letterCombinations("234"));
    }
}
