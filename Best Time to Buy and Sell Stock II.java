class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        for(int i=1;i<n;i++){
            int max = Math.max(0,prices[n-1]-prices[n-1-i]);
            for(int j=0;j<i;j++)
                max = Math.max(max,prices[n+j-1-i]-prices[n-i-1]+dp[i-1-j]);
            dp[i]=max;
        }
        return dp[n-1];
    }
}
