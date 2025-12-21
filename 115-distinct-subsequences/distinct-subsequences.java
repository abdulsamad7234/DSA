class Solution {
    public int numDistinct(String s, String t) {
        int dp[][] = new int[s.length() + 1][t.length() + 1];
        for(int i = 0; i < s.length() + 1; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i < s.length() + 1; i++){
            for(int j = 1; j < t.length() + 1; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    int firstChoice = dp[i - 1][j - 1];
                    int secondChoice = dp[i - 1][j];
                    dp[i][j] = firstChoice + secondChoice;
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public int solve(String s, String t, int i, int j){
        if(j == 0){
            return 1;
        }
        if(i == 0){
            return 0;
        }
        if(s.charAt(i - 1) == t.charAt(j - 1)){
            int firstChoice = solve(s, t, i - 1, j - 1);
            int secondChoice = solve(s, t, i - 1, j);
            return firstChoice + secondChoice;
        }
        return solve(s, t, i - 1, j);

    }
}