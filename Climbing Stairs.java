class Solution {
    int[] dp;
    public int climbStairs(int n) {
        this.dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        if(n==1) return 1;
        dp[2] = 2;
        return helper(n);
    }
    public int helper(int n){
        if(n==0) return 0;
        if(dp[n]!=0) return dp[n];
        int val = helper(n-1) + helper(n-2);
        dp[n] = val;
        return val;
    }
}
