class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> list = new ArrayList<>();
        int[] prefixSum = new int[n+1];
        for(int i=0;i<n;i++) {prefixSum[i+1] = prefixSum[i]+nums[i]; list.add(nums[i]);}
        for(int i=1;i<n;i++){
            for(int j=i+1;j<=n;j++){
                list.add(prefixSum[j]-prefixSum[i-1]);
            } 
        }
        list.sort(null);
        long answer = 0L;
        for(int i=left-1;i<right;i++) answer = (answer + list.get(i))%1_000_000_007;
        return (int)answer;
    }
}
