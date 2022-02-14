class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length(),max=0;
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(i>0 && c==')'){
                if(s.charAt(i-1)=='(') dp[i]=dp[Math.max(0,i-2)]+2;
                else{
                    if((i-dp[i-1]-1)>=0&&s.charAt(i-dp[i-1]-1)=='(')
                        dp[i]=dp[Math.max(0,i-dp[i-1]-2)]+dp[i-1]+2;
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
