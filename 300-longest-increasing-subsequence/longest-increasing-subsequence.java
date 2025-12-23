class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i = 1; i < n; i++){
            if(nums[i] > list.get(list.size() - 1)){
                list.add(nums[i]);
            }else{
                list.set(lowerBound(list, nums[i]), nums[i]);
            }
        }
        return list.size();
    }

    int lowerBound(ArrayList<Integer> list, int target){
        int low = 0;
        int high = list.size() - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(list.get(mid) == target){
                return mid;
            }else if(list.get(mid) < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
}