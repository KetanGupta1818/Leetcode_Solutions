class Solution {
    public int singleNonDuplicate(int[] nums) {
        return binarySearch(nums,0,nums.length-1);
    }
    public int binarySearch(int[] nums, int left, int right){
        int mid = left + (right - left)/2;
        if(left==right) return nums[mid];
        if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1]) return nums[mid];
        if(mid%2==0) return nums[mid]==nums[mid+1]?binarySearch(nums,mid+2,right):binarySearch(nums,left,mid-2);
        return nums[mid]==nums[mid+1]?binarySearch(nums,left,mid-1):binarySearch(nums,mid+1,right);   
    }
}
