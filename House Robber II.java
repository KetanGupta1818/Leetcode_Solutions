class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        //Selecting First house and not selecting last house;
        int[] dp = new int[n-1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<n-1;i++){
            if(dp[i-1]>nums[i]+dp[i-2]) dp[i] = dp[i-1];
            else dp[i] = nums[i]+dp[i-2];
        }
        //Selecting Last house and not the first
        int[] dp1 = new int[n];
        dp1[n-1] = nums[n-1];
        dp1[n-2] = Math.max(nums[n-1],nums[n-2]);
        for(int i=n-3;i>0;i--){
            if(nums[i]+dp1[i+2]>dp1[i+1]) dp1[i] = nums[i]+dp1[i+2];
            else dp1[i] = dp1[i+1];
        }
        return Math.max(dp[n-2],dp1[1]);
    }
}
