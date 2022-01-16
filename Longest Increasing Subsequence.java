class Solution {
    public int lengthOfLIS(int[] nums) {
        //O(n2) time complexity
        int max = 1;
        int n = nums.length;
        int[] dp = new int[n];
        //Arrays.fill(dp,1);
        for(int i=0;i<n;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
