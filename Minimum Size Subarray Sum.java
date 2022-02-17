class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length,sum=0,left=0,min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            while(sum>=target){
                min = Math.min(min,i-left+1);
                sum-=nums[left++];
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
