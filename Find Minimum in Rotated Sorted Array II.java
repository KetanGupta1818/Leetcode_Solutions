class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int lo=0,hi=nums.length-1;
        while(lo <= hi){
            int m = (lo+hi)>>1;
            min = Math.min(min,nums[m]);
            if(nums[m] < nums[hi]) hi=m-1;
            else if(nums[m] == nums[hi]) hi--;
            else lo=m+1;
        }
        return min;
    }
}
