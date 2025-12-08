class Solution {
    int m;
    int n;
    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        n = dungeon[0].length;
        int dp[][] = new int[m][n];
        for(int a = 0; a < m; a++){
            for(int b = 0; b < n; b++){
                dp[a][b] = -1;
            }
        }
        return helper(0, 0, dungeon, dp);
    }

    public int helper(int i, int j, int dungeon[][], int dp[][]){
        if(i >= m || j >= n){
            return (int) 1e9;
        }
        
        if(i == m - 1 && j == n - 1){
            if(dungeon[i][j] > 0){
                return 1;
            }else{
                return Math.abs(dungeon[i][j]) + 1;
            }
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int down = helper(i + 1, j, dungeon, dp);
        int right = helper(i, j + 1, dungeon, dp);
        int need = Math.min(down, right) - dungeon[i][j];
        return dp[i][j] = (need <= 0) ? 1 : need;

    }
}