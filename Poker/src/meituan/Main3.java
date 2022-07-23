package meituan;

public class Main3 {

    //按对角线顺序(之字形)
    //1 2  6
    //3 5  7
    //4 8  11
    //9 10 12

    public static int[][] generateMatrix(int m, int n){
        int[][] res = new int[m][n];
        int curVal = 1;
        int row = 0, col = 0;
        for(int i = 0; i < m * n; i++){
            res[row][col] = curVal++;
            if((row + col) % 2 == 0){
                if(col == n - 1){
                    ++row;
                }else if(row == 0){
                    ++col;
                }else{
                    --row;
                    ++col;
                }
            }else{
                if(row == m - 1){
                    ++col;
                }else if(col == 0){
                    ++row;
                }else{
                    ++row;
                    --col;
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
