class Solution {
    long[] dp;
    long max;
    public long mostPoints(int[][] questions) {
        int n = questions.length;
         dp = new long[n];
        dp[n-1] = questions[n-1][0];
        max =  dp[n-1];
        long ans = maxPoints(questions,0);
        return ans;
    }
    public long maxPoints(int[][] questions, int qn){
        if(qn>=questions.length) return 0;
        if(dp[qn]!=0) return dp[qn];
        dp[qn] = Math.max(questions[qn][0]+maxPoints(questions,qn+questions[qn][1]+1),maxPoints(questions,qn+1));
        max = Math.max(max,dp[qn]);
        return dp[qn];
    }
}
