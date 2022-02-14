class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n==1 || nums[0]<nums[n-1]) return nums[0]; //No rotation
        if(nums[n-1]<nums[0] && nums[n-1]<nums[n-2]) return nums[n-1]; //Complete Rotation
        return bs(nums,0,n-1);
    }
    public int bs(int[] nums, int left, int right){
        int mid=left+(right-left)/2;
        if(nums[mid]<nums[mid+1]&&nums[mid]<nums[mid-1]) return nums[mid];
        else if(nums[mid]>=nums[0]) return bs(nums,mid+1,right);
        else return bs(nums,left,mid-1);
    }
}
