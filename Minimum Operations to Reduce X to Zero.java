class Solution {
    public int minOperations(int[] nums, int x) {
        int target = -x,right=0,n=nums.length,sum=0,max_length=0;
        for(int num: nums) target+=num;
        if(target == 0) return nums.length;
        for(int i=0;i<nums.length;i++){
            while(sum<target && right<n) sum+=nums[right++];
            if(sum==target) max_length=Math.max(max_length,right-i);
            sum-=nums[i];
        }
        return max_length==0?-1:nums.length - max_length;
    }
}
