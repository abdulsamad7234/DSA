class Solution {
    public int coinChange(int[] coins, int amount) {
        int [][] dp = new int[coins.length][amount+1];
        for(int i=0;i<=amount;i++){
            dp[0][i] = i%coins[0]==0?i/coins[0]:Integer.MAX_VALUE-1;
        }
        for(int i=1;i<coins.length;i++){
            for(int j=1;j<=amount;j++){
                int nottake = dp[i-1][j];
                int take = (j-coins[i])>=0?1 + dp[i][j-coins[i]]:Integer.MAX_VALUE-1;
                dp[i][j] = Math.min(take,nottake);
            }
        }
        int ans = dp[coins.length-1][amount];
        //int ans = solve(coins,amount,coins.length-1,dp);
        return ans >= Integer.MAX_VALUE-1?-1:ans;
    }
}