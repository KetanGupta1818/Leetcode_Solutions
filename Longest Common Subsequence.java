class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return LCS(text1,text2,0,0);
    }
    public int LCS(String X, String Y, int i, int j){
        if(i>=X.length() || j>=Y.length()) return 0;
        if(dp[i][j]==-1){
            if(X.charAt(i)==Y.charAt(j)) dp[i][j] = 1 + LCS(X,Y,i+1,j+1);
            else dp[i][j] = Math.max(LCS(X,Y,i+1,j),LCS(X,Y,i,j+1));
        }
        return dp[i][j];
    }
}
