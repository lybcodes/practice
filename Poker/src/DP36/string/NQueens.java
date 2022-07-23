package DP36.string;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    int n;
    //存放皇后的位置
    private int[] rows;
    //标记是否被列方向的皇后攻击
    private int[] cols;
    //标记是否被主对角线方向的皇后攻击
    private int[] mains;
    //标识是否被此对角线攻击
    private int[] secondary;

    private List<List<String>> output;

    public List<List<String>> solveNQueens(int n){
        this.n = n;
        this.rows = new int[n];
        this.cols = new int[n];
        this.mains = new int[2 * n - 1];//n*n的方针中主对角线和次对角线的个数都是2*n-1
        this.secondary = new int[2 * n - 1];
        this.output = new ArrayList<>();

        dfs(0);
        return output;
    }
    //回溯，每一行放置一个皇后
    private void dfs(int row){
        if(row >= n) return;
        //分别尝试在当前行的每一列放置皇后
        for(int col = 0; col < n; col++){
            if(isNotUnderAttack(row, col)){
                //未被攻击，在当前位置上放置皇后
                placeQueen(row, col);
                if(row == n - 1){
                    addSolution();
                }
                //接着在下一行放置皇后
                dfs(row + 1);
                //回溯，将当前位置的皇后删除掉
                removeQueen(row, col);
            }
        }
    }
    private void placeQueen(int row, int col){
        //在 row 行，col 列放置皇后
        rows[row] = col;
        //当前位置的列方向已经有皇后了
        cols[col] = 1;
        //当前位置的主对角线已经有皇后了
        mains[row - col + n - 1] = 1;
        //当前位置的次对角线已经有皇后了
        secondary[row + col] = 1;
    }
    private void removeQueen(int row, int col){
        //移除 row 行上的皇后
        rows[row] = 0;
        //当前位置的列方向就没有皇后了
        cols[col] = 0;
        //当前位置的主对角线方向上没有皇后了
        mains[row - col + n - 1] = 0;
        //当前位置的次对角线方向上没有皇后了
        secondary[row + col] = 0;
    }
    //判断 row 行， col 列这个位置有没有被其它方向的皇后攻击
    private boolean isNotUnderAttack(int row, int col){
        /**
         * 判断的逻辑
         * 1、当前位置的这一列方向没有皇后攻击
         * 2、当前位置的这一主对角线方向没有皇后攻击
         * 3、当前位置的这一次对角线方向没有皇后攻击
         */
        int res = cols[col] + mains[row - col + n -1] + secondary[row + col];
        //如果三个方向都没有被攻击，则res = 0
        return res == 0;
    }
    private void addSolution(){
        List<String> solution = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int col = rows[i];
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < col; j++){
                sb.append(".");
            }
            sb.append("Q");
            for(int j = 0; j < n - col - 1; j++){
                sb.append(".");
            }
            solution.add(sb.toString());
        }
        output.add(solution);
    }
}
