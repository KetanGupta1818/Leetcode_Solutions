class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        int left=0,right=nums.length-1;
        int mid = left+(right-left)/2;
        if(nums.length==2){
            if(nums[0]>nums[1]) return 0;
            return 1;
        }
        while(true){
            mid = left+(right-left)/2;
            if((mid==nums.length-1&&nums[mid]>nums[mid-1]) || (mid==0&&nums[mid]>nums[1]) || (nums[mid]>nums[mid+1]&&nums[mid]>nums[mid-1])) break;
            if(nums[mid]<nums[mid+1]) left=mid+1;
            else right=mid-1;
        }
        return mid;
    }
}
