package DP36.string;

import java.util.ArrayList;
import java.util.List;

//lc93 复原Ip地址 同样抽象成树形结构
public class RestoreIpAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0){
            return res;
        }
        dfs(s, res, 0, "", 0);
        return res;
    }
    private void dfs(String s, List<String> res, int index, String resored, int count){
        if(count > 4)
            return;
        if(count == 4 && index == s.length()){
            res.add(resored);
            return;
        }
        for(int segmentLen = 1; segmentLen < 4; segmentLen++){
            if(index + segmentLen > s.length()) break;
            String segment = s.substring(index, index + segmentLen);
            if(!isValidIpSegment(segment)) continue;
            String suffix = count == 3 ? "" : ".";
            dfs(s, res, index + segmentLen, resored + segment + suffix, count+1);
            //这里回溯为什么没有删除resored最后拼接的字符串？
            //因为用的是String类型，不可变，每次在resored后面拼接字符串相当于新建了一个String,所以不需要回溯删除
        }
    }

    private boolean isValidIpSegment(String segmnet){
        //长度不能大于3
        if(segmnet.length() > 3) return false;

        //1、ip段如果以0开始，那这个ip段只能是0
        if(segmnet.charAt(0) == '0') return segmnet.length() == 1;
        //2、ip段小于等于255
        if(Integer.valueOf(segmnet) > 255) return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new RestoreIpAddress().restoreIpAddresses("010123"));
    }
}
