//Simple Sliding window
class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length,ans=1,mask=0;
        for(int lo=-1,hi=0;hi<n;hi++){
            while((mask&nums[hi])!=0) mask ^= nums[++lo];
            mask |= nums[hi];
            ans = Math.max(ans,hi-lo);
        }
        return ans;
    }
}
