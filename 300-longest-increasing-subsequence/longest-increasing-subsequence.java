class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        Integer dp[][] = new Integer[n + 1][n + 1];
        return solve(nums.length - 1, -1, nums, dp);
    }

    public int solve(int i, int prev, int nums[], Integer dp[][]){
        if(i == -1){
            return 0;
        }
        if(dp[i][prev + 1] != null){
            return dp[i][prev + 1];
        }
        int notTake = solve(i - 1, prev, nums, dp);
        int take = 0;
        if(prev == -1 || nums[prev] > nums[i]){
            take = 1 + solve(i - 1, i, nums, dp);
        }
        return dp[i][prev + 1] = Math.max(notTake, take);
    }
}