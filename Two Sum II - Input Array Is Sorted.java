class Solution {
    public int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            if(nums[start]+nums[end]>target) end--;
            else if(nums[start]+nums[end]<target) start++;
            else {
                start++;
                end++;
                break;
            }
        }
        return new int[]{start,end};
    }
}
