class Solution {
    public int minSwaps(int[] nums) {
        int ones = 0;
        for(int v: nums) ones+=v;
        if(ones==0 || ones==1) return 0;
        int start = 0;
        int end = ones - 1;
        int zeros = 0;
        for(int i=0;i<ones;i++) if(nums[i]==0) zeros++;
        int min = zeros;
        int rep = 1;
        while(rep<=nums.length){
            if(nums[start++]==0) zeros--;
            if(nums[(++end%nums.length)]==0) zeros++;
            min = Math.min(min,zeros);
            rep++;
        }
        return min;
    }
}
