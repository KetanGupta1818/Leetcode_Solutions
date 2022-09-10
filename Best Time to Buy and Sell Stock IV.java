//If we have stock in hand we can either sell it or ignore this day
//Else we do not have a stock in hand we can either buy a stock or ignore this day

//Recursive Solution

class Solution {
    public int maxProfit(int k, int[] prices) {
        return f(k,0,prices,false);
    }
    private int f(int k, int day, int[] prices, boolean stock_in_hand){
        if(day==prices.length || k==-1) return 0;
        if(stock_in_hand) return Math.max(prices[day]+f(k,day+1,prices,false),f(k,day+1,prices,true));
        else return Math.max(f(k-1,day+1,prices,true)-prices[day],f(k,day+1,prices,false));
    }
}


//Dp solution

class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[k+1][prices.length][2];
        return f(k,0,prices,false,dp);
    }
    private int f(int k, int day, int[] prices, boolean stock_in_hand,int[][][] dp){
        if(day==prices.length || k==-1) return 0;
        int s = (stock_in_hand)?1:0;
        if(dp[k][day][s]!=0) return dp[k][day][s];
        if(s==1) return dp[k][day][s] = Math.max(prices[day]+f(k,day+1,prices,false,dp),f(k,day+1,prices,true,dp));
        else return dp[k][day][s] = Math.max(f(k-1,day+1,prices,true,dp)-prices[day],f(k,day+1,prices,false,dp));
    }
}
