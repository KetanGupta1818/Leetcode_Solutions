class Solution {
    public int countHillValley(int[] nums) {
        int counter=0;
        int n = nums.length;
        for(int i=1;i<n-1;i++){
            int bp = i-1;
            int fp = i+1;
            while(bp>=0 && nums[bp]==nums[i]) bp--;
            while(fp<n && nums[fp]==nums[i]) fp++;
            if(bp==-1 || fp==n) continue;
            if(nums[i]>nums[bp] && nums[i]>nums[fp]) counter++;
            if(nums[i]<nums[bp] && nums[i]<nums[fp]) counter++;
            i=fp-1;
        }
        return counter;
    }
}
