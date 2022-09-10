//recursion Solution (TLE)

class Solution {
    public int numDistinct(String s, String t) {
        return f(s,t,0,0);
    }
    private int f(String s, String t, int i, int j){
        if(j==t.length()) return 1;
        if(i==s.length()) return 0;
        if(s.charAt(i)==t.charAt(j)) return f(s,t,i+1,j+1) + f(s,t,i+1,j);
        return f(s,t,i+1,j);
    }
}



//Dp solution  --> Just Catch it

class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int i=0;i<s.length();i++) for(int j=0;j<t.length();j++) dp[i][j]=-1;
        return f(s,t,0,0,dp);
    }
    private int f(String s, String t, int i, int j,int[][] dp){
        if(j==t.length()) return 1;
        if(i==s.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)) return dp[i][j]= f(s,t,i+1,j+1,dp) + f(s,t,i+1,j,dp);
        return dp[i][j] = f(s,t,i+1,j,dp);
    }
}
