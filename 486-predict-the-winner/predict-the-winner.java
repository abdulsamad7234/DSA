class Solution {
    public boolean predictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length - 1) >= 0;
    }

    public int helper (int nums[], int i, int j){
        if(i == j){
            return nums[i];
        }

        int leftPick = nums[i] - helper(nums, i + 1, j);
        int rightPick = nums[j] - helper(nums, i, j - 1);

        return Math.max(leftPick, rightPick);
    }
}