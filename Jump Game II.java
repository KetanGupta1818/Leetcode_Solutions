class Solution {
    public int jump(int[] nums) {
       int n = nums.length;
        if(n==0 || n==1) return 0;
        int[] dp = new int[n];//An array which contains minimum number of jumps required to reach ith position. 
        dp[0] = 0; //0 number of jumps is required to reach at position 1 beacuse we start at that position.
        for(int i=0;i<n-1;i++){//we are not considering i<n because we wont jump from the last position
            int jumps = nums[i];
            for(int j=1;j<=jumps;j++){
                if(i+j>=n) break; //Jump has taken us out of the array.
                if(dp[i+j]==0) dp[i+j] = dp[i]+1; //We are visiting this position for the first time.
                else dp[i+j] = Math.min(dp[i]+1,dp[i+j]);
                //We had already visited this node. Check if the current route takes less number of jumps than the previous route.
            }
        }
        return dp[n-1];
    }
}
