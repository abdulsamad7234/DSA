class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        Boolean dp[][] = new Boolean[n + 1][m + 1];
        return solve(0, 0, s1, s2, s3, dp);
    }

    public boolean solve(int i, int j, String s1, String s2, String s3, Boolean dp[][]){
        if(i == s1.length() && j == s2.length() && i + j == s3.length()){
            return true;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        boolean ans = false;
        if(i < s1.length() && i + j < s3.length() && s1.charAt(i) == s3.charAt(i + j)){
            ans = ans || solve(i + 1, j, s1, s2, s3, dp);
        }
        if(j < s2.length() && i + j < s3.length() && s2.charAt(j) == s3.charAt(i + j)){
            ans = ans || solve(i, j + 1, s1, s2, s3, dp);
        }
        return dp[i][j] = ans;
    }
}