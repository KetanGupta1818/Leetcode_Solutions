class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        for(int v=3;v<=n;v++){
            for(int i=1;i<=v/2;i++){
                int lmax = Math.max(i,dp[i]);
                int rmax = Math.max(v-i,dp[v-i]);
                dp[v] = Math.max(dp[v],lmax*rmax);
            }
        }
        return dp[n];
    }
}
