package DP36;

public class SudokuSolver {
    public void solveSudoku(char[][] board){
        boolean[][] rowUsed = new boolean[9][10];
        boolean[][] colUsed = new boolean[9][10];
        boolean[][][] boxUsed = new boolean[3][3][10];

        //初始化
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                int num = board[i][j] - '0';
                if(num >= 1 && num <= 9){
                    rowUsed[i][num] = true;
                    colUsed[j][num] = true;
                    boxUsed[i/3][j/3][num] = true;
                }
            }
        }
        if(dfs(board, 0, 0, rowUsed, colUsed, boxUsed))
            return;
    }
    private boolean dfs(char[][] board, int row, int col,
                        boolean[][] rowUsed,
                        boolean[][] colUsed,
                        boolean[][][] boxUsed){
        if(col == board[0].length){
            row++;
            col = 0;
            if(row == board.length){
                return true;
            }
        }
        if(board[row][col] == '.'){
            //填充1-9
            for(int i = 1; i <= 9; i++){
                boolean canPlaced = rowUsed[row][i] || colUsed[col][i] || boxUsed[row/3][col/3][i];
                if(!canPlaced){
                    rowUsed[row][i] = true;
                    colUsed[col][i] = true;
                    boxUsed[row/3][col/3][i] = true;
                    board[row][col] = (char)('0' + i);
                    //继续填充下一个
                    if(dfs(board, row, col + 1, rowUsed, colUsed, boxUsed)){
                        return true;
                    }
                    //填充失败则回溯
                    rowUsed[row][i] = false;
                    colUsed[col][i] = false;
                    boxUsed[row/3][col/3][i] = false;
                    board[row][col] = '.';
                }
            }
        }else{
            //不为空则跳过这个空格
            return dfs(board, row, col + 1, rowUsed, colUsed, boxUsed);
        }
        return false;
    }


}
