class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];
        for(int i = 0; i < n; i++){
            dp[i][0] = 1;
        }
        for(int j = 1; j < amount + 1; j++){
            if(j % coins[0] == 0){
                dp[0][j] = 1;
            }else{
                dp[0][j] = 0;
            }
        }

        for(int i = 1;  i < n; i++){
            for(int j = 1; j < amount + 1; j++){
                int notTake = dp[i - 1][j];
                int take = (j - coins[i]) >= 0 ? dp[i][j - coins[i]] : 0;
                dp[i][j] = take + notTake;
            }
        }

        return dp[n - 1][amount];
    }

    public int helper(int idx, int amount, int coins[], Integer dp[][]){
        if(amount == 0){
            return 1;
        }
        if(idx == 0){
            if(amount % coins[idx] == 0){
                return 1;
            }else{
                return 0;
            }
        }
        
        if(dp[idx][amount] != null){
            return dp[idx][amount];
        }

        int notTake = helper(idx - 1, amount, coins, dp);
        int take = (amount - coins[idx]) >= 0 ? helper(idx, amount - coins[idx], coins, dp) : 0;
        return dp[idx][amount] = notTake + take;
    }
}