class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = 1;
        }
        int max = 1;
        for(int curr = 1; curr < n; curr++){
            for(int prev = 0; prev < curr; prev++){
                if(nums[prev] < nums[curr] && dp[prev] + 1 > dp[curr]){
                    dp[curr] = dp[prev] + 1;
                    max = Math.max(max, dp[curr]); 
                }
            }
        }
        return max;
    }
}