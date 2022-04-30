class Solution {
    public int minimumAverageDifference(int[] nums) {
        if(nums.length==1) return 0;
        long[] prefixSum = new long[nums.length];
        prefixSum[0] = nums[0];
        for(int i=1;i<nums.length;i++) prefixSum[i] = (long) nums[i] + prefixSum[i-1];
        int minimumDif = Integer.MAX_VALUE;
        int index = 0;
        for(int i=0;i<nums.length-1;i++){
            int prev = Math.round(prefixSum[i]/(i+1));
            int ahead = Math.round((prefixSum[nums.length-1]-prefixSum[i])/(nums.length-i-1));
            int cur = Math.abs( prev - ahead);
            if(cur<minimumDif) {

                index = i;
                minimumDif = cur;
            }
            if(prefixSum[nums.length-1]/nums.length < minimumDif) index = nums.length-1;
        }
        return index;
    }
}
