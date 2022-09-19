class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        long[][] dp = new long[m+1][n+1];
        for(int[] p: prices) dp[p[0]][p[1]] = p[2];
        for(int r=1;r<=m;r++){
            for(int c=1;c<=n;c++){
                for(int h=1;h<=r/2;h++) dp[r][c] = Math.max(dp[r][c],dp[h][c]+dp[r-h][c]);
                for(int w=1;w<=c/2;w++) dp[r][c] = Math.max(dp[r][c],dp[r][c-w]+dp[r][w]);
            }
        }
        return dp[m][n];
    }
}
