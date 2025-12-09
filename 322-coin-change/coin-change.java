class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Integer dp[][] = new Integer[n][amount + 1];
        int ans = solveRec(n - 1, amount, coins, dp);
        if(ans == (int)1e9){
            return -1;
        }
        return ans;
    }

    public int solveRec(int idx, int amount, int coins[], Integer dp[][]){
        if(amount == 0){
            return 0;
        }
        if(idx == 0){
            if(amount % coins[0] == 0){
                return amount / coins[0];
            }else{
                return (int)1e9;
            }
        }

        if(dp[idx][amount] != null){
            return dp[idx][amount];
        }
        int notTake = solveRec(idx - 1, amount, coins, dp);
        int take = (coins[idx] > amount) ? (int)1e9 : 1 + solveRec(idx, amount - coins[idx], coins, dp);
        return dp[idx][amount] = Math.min(notTake, take);
    }
}