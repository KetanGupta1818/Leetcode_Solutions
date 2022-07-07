class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length()) return false;
        return fun(0,s1,0,s2,s3,0,new int[s1.length()][s2.length()]);
    }
    private boolean fun(int i, String s1, int j, String s2, String s3, int k, int[][] memo){
        if(i == s1.length()) return s2.substring(j).equals(s3.substring(k));
        if(j == s2.length()) return s1.substring(i).equals(s3.substring(k));
        if(memo[i][j] != 0) return memo[i][j] == 1;
        boolean ans =
                (s1.charAt(i) == s3.charAt(k) && fun(i+1,s1,j,s2,s3,k+1,memo)) ||
                        (s2.charAt(j) == s3.charAt(k) && fun(i,s1,j+1,s2,s3,k+1,memo));
        memo[i][j] = (ans?1:-1);
        return ans;
    }
}
