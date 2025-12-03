class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int [m][n];
        return solve(0, 0, m, n, dp);
    }

    int solve(int sr, int sc, int m, int n, int dp[][]){
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(i == m - 1 || j == n - 1){
                    dp[i][j] = 1;
                }else{
                    int right = dp[i][j + 1];
                    int down = dp[i + 1][j];
                    dp[i][j] = right + down;
                }
            }
        }
        return dp[0][0];
    }
}