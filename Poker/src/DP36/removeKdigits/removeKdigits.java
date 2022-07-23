package DP36.removeKdigits;
//lc402 贪心
public class removeKdigits {
    public String removeKdigits(String num, int k){
        StringBuilder sb = new StringBuilder(num);
        for(int i = 0; i < k; i++){
            boolean hasDeleted = false;
            for(int j = 1; j < sb.length(); j++){
                if(sb.charAt(j) < sb.charAt(j - 1)){
                    sb.deleteCharAt(j - 1);
                    hasDeleted = true;
                    break;
                }
            }
            if(!hasDeleted) sb.deleteCharAt(sb.length() - 1);
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
