class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m + 1][n + 1];
        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else{
                    int include  = dp[i][j - 1];
                    int exclude = dp[i - 1][j];
                    dp[i][j] = Math.max(include, exclude);
                }  
            }
        }
        return (dp[m][n]);
    }
}