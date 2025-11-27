class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0] != 0){
            return false;
        }
        return check(grid, 0, 0, 0);
    }
    public static boolean check(int grid[][], int i, int j, int num){
        int n = grid.length;
        if(num == n * n - 1){
            return true;
        }

        if(i + 2 < n && j + 1 < n && grid[i+2][j+1] == num + 1){
            return check(grid, i + 2, j + 1, grid[i + 2][j + 1]);
        }
        else if(i + 2 < n && j - 1>= 0 && grid[i + 2][j - 1] == num + 1){
            return check(grid, i + 2, j - 1, grid[i + 2][j - 1]);
        }
        else if(i  - 2 >= 0 && j + 1< n && grid[i - 2][j + 1] == num + 1){
            return check(grid, i - 2, j + 1, grid[i - 2][j + 1]);
        }
        else if(i - 2 >= 0 && j - 1>= 0 && grid[i - 2][j - 1] == num + 1){
            return check(grid, i - 2, j - 1, grid[i - 2][j - 1]);
        }
        else if(i + 1 < n && j + 2< n && grid[i + 1][j + 2] == num + 1){
            return check(grid, i + 1, j + 2, grid[i + 1][j + 2]);
        }
        else if(i - 1 >= 0 && j + 2< n && grid[i - 1][j + 2] == num + 1){
            return check(grid, i - 1, j + 2, grid[i - 1][j + 2]);
        }
        else if(i + 1 < n && j - 2>= 0 && grid[i + 1][j - 2] == num + 1){
            return check(grid, i + 1, j - 2, grid[i + 1][j - 2]);
        }
        else if(i - 1 >= 0 && j  - 2 >= 0 && grid[i - 1][j - 2] == num + 1){
            return check(grid, i - 1, j - 2, grid[i - 1][j - 2]);
        }

        return false;
    }
}