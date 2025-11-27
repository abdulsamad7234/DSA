class Solution {
    public boolean isSafe(char board[][], int row, int col, char num){
        //row check
        for(int j = 0; j < 9; j++){
            if(board[row][j] == num){
                return false;
            }
        }

        //col check
        for(int i = 0; i < 9; i++){
            if(board[i][col] == num){
                return false;
            }
        }

        int newRow = (row / 3) * 3;
        int newCol = (col / 3) * 3;

        for(int i = newRow; i < newRow + 3; i++){
            for(int j = newCol; j < newCol + 3; j++){
                if(board[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                char ch = board[i][j];
                board[i][j] = '.';

                if(!isSafe(board, i ,j, ch)){
                    return false;
                }

                board[i][j] = ch;
            }
        }
        return true;
    }
}