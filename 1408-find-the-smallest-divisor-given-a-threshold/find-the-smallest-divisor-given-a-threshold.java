class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = -1;
        for(int ele : nums){
            high = Math.max(high, ele);
        }
        int ans = 0;
        while(low <= high){
            int mid = (low + high) / 2;
            if(isValid(nums, mid, threshold)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean isValid(int nums[], int mid, int threshold){
        int h = 0;
        for(int ele : nums){
            if(ele < mid){
                h += 1;
            }else{
                if(ele % mid == 0){
                    h += (ele / mid);
                }else{
                    h += (ele / mid) + 1;
                }
            }
            if(h > threshold){
                return false;
            }
        }
        return true;
    }
}