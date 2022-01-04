class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dpMin = new int[n];
        int[] dpMax = new int[n];
        dpMin[0] = nums[0];dpMax[0] = nums[0];
        int ans = nums[0];
        for(int i=1;i<n;i++){
            dpMin[i] = Math.min(nums[i],nums[i]>=0?nums[i]*dpMin[i-1]:nums[i]*dpMax[i-1]);
            dpMax[i] = Math.max(nums[i],nums[i]*(nums[i]>=0?dpMax[i-1] :dpMin[i-1] ));
            ans = Math.max(ans,dpMax[i]);
        }
        return ans;
    }
}
