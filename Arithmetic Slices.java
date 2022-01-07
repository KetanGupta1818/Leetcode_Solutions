class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n<3) return 0;
        int[] dp = new int[n];
        if(nums[2]-nums[1]==nums[1]-nums[0]) dp[2]=1;
        int result = dp[2];
        for(int i=3;i<n;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                dp[i]=dp[i-1]+1;
                result+=dp[i];
            }
        }
        return result;
    }
}
