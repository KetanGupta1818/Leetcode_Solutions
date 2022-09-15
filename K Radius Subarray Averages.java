class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n+1];
        for(int i=1;i<=n;i++) prefixSum[i] = prefixSum[i-1]+nums[i-1];
        int[] answer = new int[n];
        Arrays.fill(answer,-1);
        for(int i=k;i<n-k;i++) answer[i] = (int)((prefixSum[i+k+1]-prefixSum[i-k])/(2L*k+1));
        return answer;
    }
}
