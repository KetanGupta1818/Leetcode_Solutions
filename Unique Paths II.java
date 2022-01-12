class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if(obstacleGrid[0][0]==0) dp[0][0] = 1;
        for(int r=1;r<m;r++){
            if(obstacleGrid[r][0] == 0) dp[r][0] = dp[r-1][0]; 
        }
        for(int c=1;c<n;c++){
            if(obstacleGrid[0][c] == 0) dp[0][c] = dp[0][c-1];
        }
        for(int r=1;r<m;r++){
            for(int c=1;c<n;c++){
                if(obstacleGrid[r][c]==0) dp[r][c] = dp[r-1][c] + dp[r][c-1]; 
            }
        }
        return dp[m-1][n-1];
    }
}
