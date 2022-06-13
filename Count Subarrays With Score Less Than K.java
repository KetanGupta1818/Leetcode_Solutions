class Solution {
    public long countSubarrays(int[] nums, long k) {
        long answer=0L,windowSum=0L;
        for(int bp=-1,i=0;i<nums.length;i++){
            windowSum+=nums[i];
            while(bp<i && windowSum*(i-bp)>=k) windowSum-=nums[++bp];
            answer+=(i-bp);
        }
        return answer;
    }
}
