class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = -1;
        for(int ele : piles){
            high = Math.max(high, ele);
        }
        int ans = 0;
        while(low <= high){
            int mid = (low + high) / 2;
            if(isValid(piles, mid, h)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean isValid(int piles[], int mid, int totalHour){
        int h = 0;
        for(int ele : piles){
            if(ele < mid){
                h += 1;
            }else{
                if(ele % mid == 0){
                    h += (ele / mid);
                }else{
                    h += (ele / mid) + 1;
                }
            }
            if(h > totalHour){
                return false;
            }
        }
        return true;
    }
}