class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int max=0,bp=-1;
        long[] prefixSum = new long[nums.length];
        prefixSum[0] = (long)nums[0];
        for(int i=1;i<nums.length;i++) prefixSum[i] = prefixSum[i-1] + nums[i];
        for(int i=0;i<nums.length;i++){
            bp = Math.max(bp,map.getOrDefault(nums[i],-1));
            max = (int)Math.max(max,prefixSum[i]-((bp==-1)?0:prefixSum[bp]));
            map.put(nums[i],i);
        }
        return max;
    }
}
