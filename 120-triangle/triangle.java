class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int dp[][] = new int[m][n];
        for(int [] row : dp){
            Arrays.fill(row, 100000);
        }
        return helper(0, 0, triangle, dp);
    }

    int helper(int i, int j, List<List<Integer>> list, int dp[][]){
        if(i == list.size() - 1){
            return list.get(i).get(j);
        }
        if(dp[i][j] != 100000){
            return dp[i][j];
        }
        int down = helper(i + 1, j, list, dp);
        int downLeft = helper(i + 1, j + 1, list, dp);
        return dp[i][j] = Math.min(down, downLeft) + list.get(i).get(j);
    }
}