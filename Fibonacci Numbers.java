class Solution {
    int[] dp;
    public int fib(int n) {
        this.dp = new int[n+1];
        return topDown(n);
    }
    public int topDown(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        if(dp[n]!=0) return dp[n];
        dp[n] = topDown(n-1)+topDown(n-2);
        return dp[n];
    }
}
