class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0 ; j < col; j++){
                if(board[i][j] == word.charAt(0) && find(board, i, j, 0, word)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean find(char board[][], int i, int j, int idx, String word){
        if(idx == word.length()){
            return true;
        }
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '$' || board[i][j] != word.charAt(idx)){
            return false;
        }

        char temp  = board[i][j];

        board[i][j] = '$';
        if(find(board, i + 1, j, idx + 1, word)){
            return true;
        }
        if(find(board, i, j + 1, idx + 1, word)){
            return true;
        }
        if(find(board, i - 1, j, idx + 1, word)){
            return true;
        }
        if(find(board, i, j - 1, idx + 1, word)){
            return true;
        }

        board[i][j] = temp;
        return false;

    }
}