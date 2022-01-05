class Solution {
    int[] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        return fun(0,prices);
    }
    public int fun(int start, int[] prices){
        if(start>=prices.length-1) return 0;
        if(dp[start]!=-1) return dp[start];
        int profit = 0;
        for(int i=start;i<prices.length;i++){
            if(prices[start]<prices[i]){
                profit = Math.max(profit,prices[i]-prices[start]+fun(i+2,prices));
            }
            profit = Math.max(profit,fun(i+1,prices));
        }
        dp[start] = profit;
        return IntStream.range(start,prices.length)
                .map(index->dp[index]).max().getAsInt();
    }
}
