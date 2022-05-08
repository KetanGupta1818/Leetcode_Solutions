class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<=1000;i++)
            if(nums.length - bs(nums,i) -1 == i) return i;
        return -1;
    }
    private int bs(int[] nums, int target){
        int lo=0,hi=nums.length-1;
        while(lo<=hi){
            int m = lo+(hi-lo)/2;
            if(nums[m]>=target) hi=m-1;
            else lo=m+1;
        }
        return hi;
    }
}
