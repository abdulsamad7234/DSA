class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean dp[][] = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for(int j = 1; j < m + 1; j++){
            boolean check = false;
            for(int k = j; k > 0; k--){
                if(p.charAt(k - 1) != '*'){
                    check = true;
                }
            }
            if(check == true){
                dp[0][j] = false;
            }else{
                dp[0][j] = true;
            }
        }
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                int ch = p.charAt(j - 1);
                if(s.charAt(i - 1) == ch || ch == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                }else if(ch == '*'){
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }
    public boolean solve(int i, int j, String s, String p, Boolean dp[][]){
        if(j == 0){
            return i == 0;
        }
        if(i == 0){
            for(int k = j; k > 0; k--){
                if(p.charAt(k - 1) != '*'){
                    return false;
                }
            }
            return true;
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        int ch = p.charAt(j - 1);
        if(s.charAt(i - 1) == ch || ch == '?'){
            return dp[i][j] = solve(i - 1, j - 1, s, p, dp);
        }else if(ch == '*'){
            return dp[i][j] = solve(i - 1, j, s, p, dp) || solve(i, j - 1, s, p, dp);
        }
            return dp[i][j] = false;
    }
}