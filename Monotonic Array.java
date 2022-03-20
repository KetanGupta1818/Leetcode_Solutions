class Solution {
    public boolean isMonotonic(int[] nums) {
        return isDecreasing(nums) || isIncreasing(nums);
    }
    public boolean isDecreasing(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]) return false;
        }
        return true;
    }
    public boolean isIncreasing(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]) return false;
        }
        return true;
    }
}
