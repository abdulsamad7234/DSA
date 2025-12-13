class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, 0, 0);
    }

    public int helper(int nums[], int target, int sum, int idx){
        if(idx == nums.length){
            if(sum == target){
                return 1;
            }else{
                return 0;
            }
        }
        int positiveSign = helper(nums, target, sum + nums[idx], idx + 1);
        int negativeSign = helper(nums, target, sum - nums[idx], idx + 1);
        return positiveSign + negativeSign;
    }
}