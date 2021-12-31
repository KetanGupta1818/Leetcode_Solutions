class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int maximumVal = -1;
        for(int ele: nums) maximumVal = Math.max(maximumVal,ele);
        int[] sumArray = new int[maximumVal+1];
        for(int ele: nums) {
            int rep = sumArray[ele]/ele;
            rep++;
            sumArray[ele] = rep*ele;
        }
        int[] dp = new int[maximumVal+1];
        dp[0] = sumArray[0];
        dp[1] = Math.max(sumArray[1],sumArray[0]);
        for(int i=2;i<=maximumVal;i++){
            if(dp[i-1]>dp[i-2]+sumArray[i]) dp[i] = dp[i-1];
            else dp[i] = dp[i-2]+sumArray[i];
        }
        return dp[maximumVal];
        
    }
}
