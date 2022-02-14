class Solution {
    public int search(int[] nums, int target) {
        if(target==nums[0]) return 0;
        if(target>nums[0]) return binarySearchGreater(nums,target,0,nums.length-1);
        else return binarySearchLesser(nums,target,0,nums.length-1);
    }
    public int binarySearchGreater(int[] nums, int target, int left, int right){
        if(left>right) return -1;
        int mid = left + (right-left)/2;
        if(nums[mid]<nums[0]) return binarySearchGreater(nums,target,left,mid-1);
        if(nums[mid]==target) return mid;
        else if(nums[mid]<target) return binarySearchGreater(nums,target,mid+1,right);
        else return binarySearchGreater(nums,target,left,mid-1);
    }
    public int binarySearchLesser(int[] nums, int target, int left, int right){
        if(left>right) return -1;
        int mid = left + (right-left)/2;
        if(nums[mid]>=nums[0]) return binarySearchLesser(nums,target,mid+1,right);
        if(nums[mid]==target) return mid;
        else if(nums[mid]<target) return binarySearchLesser(nums,target,mid+1,right);
        else return binarySearchLesser(nums,target,left,mid-1);
    }
}
