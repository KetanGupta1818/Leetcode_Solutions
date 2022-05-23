class Solution {
    int[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
       dp =  new int[strs.length][n+1][m+1];
        int[][] mat = new int[strs.length][2];
        for(int i=0;i<strs.length;i++){
            int ones = 0;
            int zeros = 0;
            for(int j=0;j<strs[i].length();j++){
                if(strs[i].charAt(j) == '1') ones++;
                else zeros++;
            }
            mat[i][0] = ones;
            mat[i][1] = zeros;
        }
        for(int i=0;i<strs.length;i++){
            for(int j=0;j<=n;j++){
                for(int k=0;k<=m;k++) dp[i][j][k] = -1;
            }
        }
        return fun(mat,0,n,m);
    }
    private int fun(int[][] mat, int index, int nOnes, int nZeros){
        int n = mat.length;
        if(n==index || (nZeros==0 && nOnes==0)) return 0;
        if(dp[index][nOnes][nZeros] != -1) return dp[index][nOnes][nZeros];
        if(mat[index][0]>nOnes || mat[index][1]>nZeros) return dp[index][nOnes][nZeros] = fun(mat,index+1,nOnes,nZeros);
        return dp[index][nOnes][nZeros] = Math.max(fun(mat,index+1,nOnes,nZeros),fun(mat,index+1,nOnes-mat[index][0],nZeros-mat[index][1])+1);
    }
}
