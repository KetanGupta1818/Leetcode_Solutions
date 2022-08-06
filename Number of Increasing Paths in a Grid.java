class Solution {
    private final static int MOD = 1_000_000_007;
    private final static int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    public int countPaths(int[][] grid) {
        long[][] dp = new long[grid.length][grid[0].length];
        fun(0,0,dp,grid);
        long sum = 0L;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                sum = (sum+fun(i,j,dp,grid))%MOD;
            }
        }
        return (int)sum;
    }
    private long fun(int r, int c, long[][] dp, int[][] grid){
        if(dp[r][c]!=0) return dp[r][c];
        for(int[] dir: directions){
            int nr = dir[0]+r;
            int nc = dir[1]+c;
            if(isValid(nr,nc,grid.length,grid[0].length) && grid[nr][nc] < grid[r][c]) dp[r][c] = (dp[r][c] + fun(nr,nc,dp,grid))%MOD;
        }
        return dp[r][c]=dp[r][c]+1;
    }
    private boolean isValid(int r, int c, int rows, int cols){
        return r>=0 && c>=0 && c<cols && r<rows;
    }
}
