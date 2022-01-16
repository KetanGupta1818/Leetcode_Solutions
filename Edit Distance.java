class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length()==0) return word2.length();
        if(word2.length()==0) return word1.length();
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        int[][] dp = new int[word1.length()][word2.length()];
        for(int i=0;i<word1.length();i++) Arrays.fill(dp[i],-1);
        return match(c1,c2,0,0,dp);
    }
    private int match(char[] c1, char[] c2, int i, int j, int[][] dp){
        if(c1.length==i) return c2.length - j;
        if(c2.length==j) return c1.length - i;
        if(dp[i][j]!=-1) return dp[i][j];
        if(c1[i]==c2[j]) dp[i][j] = match(c1,c2,i+1,j+1,dp);
        else dp[i][j] = Math.min(Math.min(match(c1,c2,i+1,j,dp),match(c1,c2,i,j+1,dp)),
                match(c1,c2,i+1,j+1,dp))+1;
        return dp[i][j];
    }
}
