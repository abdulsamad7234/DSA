class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int count[] = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int max = 1;
        for(int curr = 1; curr < n; curr++){
            for(int prev = 0; prev < curr; prev++){
                if(nums[prev] < nums[curr] && dp[prev] + 1 > dp[curr]){
                    dp[curr] = dp[prev] + 1;
                    count[curr] = count[prev];
                    max = Math.max(max, dp[curr]); 
                }else if(nums[prev] < nums[curr] && dp[prev] + 1 == dp[curr]){
                    count[curr] += count[prev];
                }
            }
        }
        int newcount = 0;
        for(int i = 0; i < n; i++){
            if(dp[i] == max){
                newcount += count[i];
            }
        }
        return newcount;
    }
}