package meituan;

public class Main2 {

    //按对角线顺序(方向一致)
    //1 3 6
    //2 5 9
    //4 8 11
    //7 10 12

    public static int[][] generateMatrix(int m, int n){
        int[][] res = new int[m][n];
        int curVal = 1;
        for(int i = 1; i < m + n; i++){
            int row = 0, col = 0;
            if(i <= m){
                row = i - 1;
                col = 0;
            }else{
                row = m - 1;
                col = i - m;
            }
            res[row][col] = curVal++;
            while(true){
                if(--row >= 0 && ++col <= n - 1){
                    res[row][col] = curVal++;
                }else{
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] res = generateMatrix(4, 3);
        for(int i = 0; i < res.length; i++){
            for(int j = 0; j < res[0].length; j++){
                if(j == res[0].length - 1){
                    System.out.println(res[i][j] + ", ");
                }else{
                    System.out.print(res[i][j] + ", ");
                }
            }
        }

    }
}
