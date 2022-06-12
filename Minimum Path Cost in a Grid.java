class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m=grid.length,n=grid[0].length;
        int[][] dp = new int[m][n];
        System.arraycopy(grid[m - 1], 0, dp[m - 1], 0, n);
        for(int row=m-2;row>=0;row--){
            for(int col=0;col<n;col++) {
                int min = Integer.MAX_VALUE;
                for (int next_col = 0; next_col < n; next_col++)
                    min = Math.min(min, dp[row + 1][next_col] + grid[row][col] + moveCost[grid[row][col]][next_col]);
                dp[row][col] = min;
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i: dp[0]) min=Math.min(i,min);
        return min;
    }
}
