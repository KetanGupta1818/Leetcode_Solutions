class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currentMaximum = nums[0];
        int kadaneMaximum = nums[0];
        int totalSum = nums[0];
        int currentMinimum = nums[0];
        int minimumSubarray = nums[0];
        for(int i=1;i<nums.length;i++){
            int value = nums[i];
            currentMaximum = value + Math.max(0,currentMaximum);
            currentMinimum = value + Math.min(0,currentMinimum);
            kadaneMaximum = Math.max(kadaneMaximum,currentMaximum);
            minimumSubarray = Math.min(minimumSubarray,currentMinimum);
            totalSum+=value;
        }
        return kadaneMaximum>0 ? Math.max(kadaneMaximum,totalSum-minimumSubarray) : kadaneMaximum;
    }
}
