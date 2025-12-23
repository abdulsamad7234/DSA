class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
    if (a[0] != b[0]) {
        return a[0] - b[0];
    }
    return b[1] - a[1];
});
        int arr[] = new int[envelopes.length];
        for(int i = 0; i < envelopes.length; i++){
            arr[i] = envelopes[i][1];
        }
        return lengthOfLIS(arr);
    }

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