class Solution {
    public int maximalSquare(char[][] matrix) {
        int ma = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            dp[i][0] = matrix[i][0] - '0';
        }
        for(int i=0;i<n;i++){
            dp[0][i] = matrix[0][i] - '0';
        }
        for(int r=1;r<m;r++){
            for(int c=1;c<n;c++){
                if(matrix[r][c]=='0') continue;
                dp[r][c] = Math.min(dp[r-1][c],Math.min(dp[r-1][c-1],dp[r][c-1]))+1;
                
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(ma<dp[i][j]) ma = dp[i][j];
            }
        }
        return ma*ma;
    }
}
