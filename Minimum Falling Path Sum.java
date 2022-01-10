class Solution {
    int[][] dp;
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        dp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(min, fun(0,i,n,matrix));
        }
        return min;
    }
    public int fun(int row, int col, int n, int[][] matrix){
        if(col<0 || col>=n) return Integer.MAX_VALUE;
        if(dp[row][col]!=Integer.MAX_VALUE) return dp[row][col];
        if(row==n-1) dp[row][col] = matrix[row][col];
        else dp[row][col] = Math.min(Math.min(fun(row+1,col-1,n,matrix),fun(row+1,col,n,matrix)),
                                    fun(row+1,col+1,n,matrix)) + matrix[row][col];
        return dp[row][col];
    }
}
