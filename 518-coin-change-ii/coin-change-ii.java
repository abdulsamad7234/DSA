class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Integer dp[][] = new Integer[n][amount + 1];
        return helper(n - 1, amount, coins, dp);
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