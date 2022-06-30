class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        long[] inc_moves = new long[nums.length];
        long[] dec_moves = new long[nums.length];
        for(int i=1;i<nums.length;i++){
            long dif = (long) (nums[i] - nums[i-1]);
            inc_moves[i] = inc_moves[i-1] + i*dif;
            int back_index = nums.length-1-i;
            long dif2 = (long) (nums[back_index+1] - nums[back_index]);
            dec_moves[back_index] = dec_moves[back_index+1] + i*dif2;
        }
        long ans = Long.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            ans = Math.min(ans,inc_moves[i]+dec_moves[i]);
        }
        return (int)ans;
    }
}
