//**Recursion TLE**

class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        return f(0,0,nums.length-1,multipliers,nums);
    }
    private int f(int index, int fp, int bp,int[] m, int[] nums){
        if(index==m.length) return 0;
        return Math.max(f(index+1,fp+1,bp,m,nums)+nums[fp]*m[index],f(index+1,fp,bp-1,m,nums)+nums[bp]*m[index]);
    }
}


//**Dp accepted**

class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int[][] dp = new int[multipliers.length][multipliers.length];
        return f(0,0,0,multipliers,nums,dp);
    }
    private int f(int index, int fp, int bp,int[] m, int[] nums,int[][] dp){
        if(index==m.length) return 0;
        if(dp[fp][bp]!=0) return dp[fp][bp];
        return dp[fp][bp] = Math.max(f(index+1,fp+1,bp,m,nums,dp)+nums[fp]*m[index],f(index+1,fp,bp+1,m,nums,dp)+nums[nums.length-1-bp]*m[index]);
    }
}
