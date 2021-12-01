class Solution {
    public void moveZeroes(int[] nums) {
        int windowSize = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0) windowSize++;
            else{
                swap(nums,i-windowSize,i);
            }
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
