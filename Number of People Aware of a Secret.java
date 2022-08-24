class Solution {
    private static final int MOD = 1_000_000_007;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[][] dp = new long[n][forget];
        dp[0][0] = 1L;
        for(int day=1;day<n;day++){
            for(int time=1;time<forget;time++) dp[day][time] = dp[day-1][time-1];
            for(int i=delay-1;i<forget-1;i++) dp[day][0] = (dp[day][0]+dp[day-1][i])%MOD;
        }
        long sum = 0L;
        for(long people: dp[n-1]) sum = (sum+people)%MOD;
        return (int)sum;
    }
}
