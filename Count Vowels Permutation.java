class Solution {
    private static int MOD = 1_000_000_007;
    public int countVowelPermutation(int n) {
        long[][] dp = new long[n+1][6];
        Arrays.fill(dp[0],1L);
        dp[0][5] = 5L;
        for(int i=1;i<dp.length;i++){
            dp[i][0] = dp[i-1][1];
            dp[i][1] = (dp[i-1][0] + dp[i-1][2])%MOD;
            dp[i][2] = (dp[i-1][0]+dp[i-1][1]+dp[i-1][3]+dp[i-1][4])%MOD;
            dp[i][3] = (dp[i-1][2]+dp[i-1][4])%MOD;
            dp[i][4] = dp[i-1][0];
            dp[i][5] = (dp[i-1][0]+dp[i-1][1]+dp[i-1][2]+dp[i-1][3]+dp[i-1][4])%MOD;
        }
        return (int)dp[n][5];
    }
}
