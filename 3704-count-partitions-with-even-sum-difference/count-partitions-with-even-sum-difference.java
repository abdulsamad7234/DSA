class Solution {
    public int countPartitions(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length - 1; i++){
            int leftSum = 0;
            int rightSum = 0;
            for(int left = 0; left <= i; left++){
                leftSum += nums[left];
            }
            for(int right = i + 1; right < nums.length; right++){
                rightSum += nums[right];
            }
            if((leftSum - rightSum) % 2 == 0){
                count++;
            }
        }
        return count;
    }
}