class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        Integer dp[][][] = new Integer[strs.length][m + 1][n + 1];
        return helper(strs, m, n, strs.length - 1, dp);
    }

    public int helper(String strs[], int m, int n, int idx, Integer dp[][][]){
        if(idx == -1){
            return 0;
        }

        if(dp[idx][m][n] != null){
            return dp[idx][m][n];
        }

        int zeros = zeroCount(strs[idx]);
        int ones = strs[idx].length() - zeros;

        int include = (m - zeros >= 0 && n - ones >= 0) ? 1 + helper(strs, m - zeros, n - ones, idx - 1, dp) : (int) -1e9;
        int exclude = helper(strs, m, n, idx - 1, dp);
        return dp[idx][m][n] = Math.max(include, exclude);
    }

    public int zeroCount(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                count++;
            }
        }
        return count;
    }
}