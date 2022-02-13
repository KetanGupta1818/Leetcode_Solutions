class Solution {
    public int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums,target,0,nums.length-1);
        if(index==-1) return new int[]{-1,-1};
        int back=index,front=index;
        System.out.println(index);
        while(back>=0 && nums[back]==target) back--;
        while(front<nums.length && nums[front]==target) front++;
        return new int[]{back+1,front-1};
    }
    public int binarySearch(int[] nums, int target, int left, int right){
        if(left>right) return -1;
        int mid = left + (right-left)/2;
        if(nums[mid]==target) return mid;
        else if(nums[mid]>target) return binarySearch(nums,target,left,mid-1);
        else return binarySearch(nums,target,mid+1,right);
    }
}
