class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] kad_arr = new int[n];
        kad_arr[0] = nums[0];
        int best_sum = nums[0];
        for(int i=1;i<n;i++){
            int cur_max = (kad_arr[i-1]+nums[i]>nums[i])?kad_arr[i-1]+nums[i]:nums[i];
            kad_arr[i] = cur_max;
            if(best_sum<cur_max) best_sum = cur_max;
        }
        return best_sum;
    }
    
}
