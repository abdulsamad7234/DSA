class Solution {
    public int rob(int[] nums) {
        int prev2 = nums[0];
        if(nums.length == 1){
            return prev2;
        }
        int prev1 = Math.max(nums[0], nums[1]);
        if(nums.length == 2){
            return prev1;
        }
        int curr = 0;
        for(int i = 2; i < nums.length - 1; i++){
            curr = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        int firstAns = curr;

        prev2 = nums[1];
        prev1 = Math.max(nums[1], nums[2]);
        if(nums.length == 3){
            return Math.max(nums[0], Math.max(nums[1], nums[2]));
        }
        curr = 0;
        for(int i = 3; i < nums.length; i++){
            curr = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return Math.max(firstAns, curr);
    }
}