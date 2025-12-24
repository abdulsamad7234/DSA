class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][1001];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], 1);
        }
        if(n <= 2){
            return n;
        }
        int maxL = 0;
        for(int curr = 1; curr < n; curr++){
            for(int prev = 0; prev < curr; prev++){
                int diff = nums[curr] - nums[prev];
                int diffIndex = diff + 500;
                if(dp[curr][diffIndex] < dp[prev][diffIndex] + 1){
                    dp[curr][diffIndex] = dp[prev][diffIndex] + 1;
                    maxL = Math.max(maxL, dp[curr][diffIndex]);
                }
            }
        }
        return maxL;
    }
}