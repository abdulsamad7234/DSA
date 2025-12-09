class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0 ;
        int n = nums.length ;
        for(int i = 0 ; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum %2 != 0){
            return false;
        }
        int tar = sum/2;
        Boolean [][] dp = new Boolean[n][tar+1];
        return helper(nums,0,tar,dp);
    }
    public boolean helper(int [] nums , int i , int target,Boolean [][] dp){
        if(target == 0){
            return true;
        }
        if(i== nums.length){
            return false;
        }
        if(dp[i][target] != null){
            return dp[i][target];
        }
        boolean nt = helper(nums,i+1,target,dp);
        boolean t = false;
        if(nums[i]<=target)
            t = helper(nums,i+1,target-nums[i],dp);
        dp[i][target] = nt||t;
        return dp[i][target];
    }
}