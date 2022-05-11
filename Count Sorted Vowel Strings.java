class Solution {
    public int countVowelStrings(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;dp[1]=5; 
        if(n==1) return dp[1];
        dp[2]=15;
        for(int i=3;i<=n;i++) dp[i] = 3*(dp[i-1]-dp[i-2]) + dp[i-3]+i+1;
        return dp[n];
    }
}
