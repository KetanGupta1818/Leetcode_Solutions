class Solution {
    public long minimumReplacement(int[] nums) {
        long moves = 0L;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<=nums[i+1]) continue;
            int divs = (int)Math.ceil(nums[i]/(nums[i+1]*1.0));
            moves += divs-1;
            nums[i]=nums[i]/divs;
        }
        return moves;
    }
}
