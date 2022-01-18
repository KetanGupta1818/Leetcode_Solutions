class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int curTarget=1;curTarget<=target;curTarget++){
            for(int num: nums){
                if(curTarget>=num) dp[curTarget] += dp[curTarget-num];
            }
        }
        return dp[target];
    }
}
