class Solution {
    public int findClosestNumber(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        while(index<nums.length && nums[index]<0) index++;
        if(index==0) return nums[0];
        if(index==nums.length) return nums[index-1];
        if(nums[index]<=Math.abs(nums[index-1])) return nums[index];
        return nums[index-1];
    }
}
