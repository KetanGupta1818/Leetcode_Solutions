class Solution {
    public int searchInsert(int[] nums, int target) {
        return Search(nums, target, 0, nums.length - 1);
    }
    public int Search(int [] nums, int target, int left, int right){
        if(left>right) return left;
        if(left==right){
            if(nums[left]<target) return left+1;
            else return left;
        }
        int mid = (left+right)/2;
        if(target>nums[mid]) return Search(nums, target, mid+1,right);
        if(target<nums[mid]) return Search(nums, target, left, mid-1);
        else return mid;
    }
}
