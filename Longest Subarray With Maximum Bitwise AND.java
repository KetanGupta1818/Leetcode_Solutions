class Solution {
    public int longestSubarray(int[] nums) {
        int max = -1;
        for(int n: nums) max = Math.max(max,n);
        int size = 1;
        int lp=0;
        for(int rp=0;rp< nums.length;rp++){
            if(nums[rp] == max){
                size = Math.max(size,rp-lp+1);
            }
            else{
                lp=rp+1;
            }
        }
        return Math.max(size, nums.length-lp);
    }
}
