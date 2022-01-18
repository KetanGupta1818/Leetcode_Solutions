class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int num=1;num<=n;num++){
            for(int s=1;s*s<=num;s++){
                dp[num]=Math.min(dp[num],dp[num-s*s]+1);
            }
        }
        return dp[n];
    }
}
