class Solution {
    public int lengthOfLIS(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int ele : nums){
            set.add(ele);
        }
        int arr2[] = new int[set.size()];
        int idx = 0;
        for(int ele : set){
            arr2[idx++] = ele;
        }
        Arrays.sort(arr2);

        return solve(nums, arr2);
    }

    int solve(int arr1[], int arr2[]){
        int n = arr1.length;
        int m = arr2.length;
        int dp[][] = new int[n + 1][m + 1];
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                if(arr1[i - 1] == arr2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j] , dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}