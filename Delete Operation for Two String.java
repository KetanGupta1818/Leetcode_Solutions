class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i],-1);
        return fun(0,0,word1,word2);
    }
    int fun(int i, int j, String w1, String w2){
        if(i==w1.length() && j==w2.length()) return 0;
        if(i==w1.length()) return w2.length()-j;
        if(j==w2.length()) return w1.length()-i;
        if(dp[i][j]!=-1) return dp[i][j];
        char c1=w1.charAt(i), c2=w2.charAt(j);
        return dp[i][j]=(c1==c2)?fun(i+1,j+1,w1,w2):1+Math.min(fun(i+1,j,w1,w2),fun(i,j+1,w1,w2));
    }
}
