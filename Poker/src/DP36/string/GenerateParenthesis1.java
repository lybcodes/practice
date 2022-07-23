package DP36.string;

import java.util.ArrayList;
import java.util.List;

//lc22 括号生成
public class GenerateParenthesis1 {
    public List<String> generateParenthesis(int n){
        List<String> res = new ArrayList<>();
        if(n < 0) return res;
        dfs(n, res, "", 0, 0);
        return res;
    }
    private void dfs(int n, List<String> res, String s, int open, int close){
        if(open > n || open < close) return;
        if(s.length() == 2 * n){
            res.add(s);
            return;
        }
        dfs(n, res, s + '(', open + 1, close);
        dfs(n, res, s + ')', open, close + 1);
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis1().generateParenthesis(3));
    }
}
