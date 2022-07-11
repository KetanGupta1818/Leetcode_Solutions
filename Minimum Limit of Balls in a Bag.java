class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int lo=1,hi=1_000_000_000;
        while(lo <= hi){
            int m = lo + (hi - lo)/2;
            if(check(nums,maxOperations,m)) hi = m-1;
            else lo = m+1;
        }
        return lo;
    }
    private boolean check(int[] nums, int maxOps, int pen){
        int ops = 0;
        for(int i=0;i<nums.length;i++){
            ops += nums[i]/pen - (nums[i]%pen==0?1:0);
        }
        return ops<=maxOps;
    }
}
