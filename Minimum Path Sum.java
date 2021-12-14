class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        for(int i=1;i<columns;i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for(int i=1;i<rows;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int r=1;r<rows;r++){
            for(int c=1;c<columns;c++){
                dp[r][c] = Math.min(dp[r-1][c],dp[r][c-1]) + grid[r][c];
            }
        }
        return dp[rows-1][columns-1];
    }
}
