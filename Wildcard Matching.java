//Recursion

class Solution {
    public boolean isMatch(String s, String p) {
        return f(s,p,0,0);
    }
    private boolean f(String s, String p, int i, int j){
        if(i==s.length() && j==p.length()) return true;
        if(i==s.length() && p.charAt(j)=='*') return f(s,p,i,j+1);
        if(i==s.length() || j==p.length()) return false;
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?') return f(s,p,i+1,j+1);
        if(p.charAt(j)!='*') return false;
        return f(s,p,i+1,j) || f(s,p,i+1,j+1) || f(s,p,i,j+1);
    }



//Dp solution

class Solution {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()][p.length()];
        return f(s,p,0,0,dp)==1;
    }
    private int f(String s, String p, int i, int j,int[][] dp){
        if(i==s.length() && j==p.length()) return 1;
        if(i==s.length() && p.charAt(j)=='*') return f(s,p,i,j+1,dp);
        if(i==s.length() || j==p.length()) return -1;
        if(dp[i][j]!=0) return dp[i][j];
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?') return dp[i][j] = f(s,p,i+1,j+1,dp);
        if(p.charAt(j)!='*') return dp[i][j] = -1;
        return dp[i][j] = Math.max(f(s,p,i+1,j,dp),Math.max(f(s,p,i+1,j+1,dp),f(s,p,i,j+1,dp)));
    }
}
