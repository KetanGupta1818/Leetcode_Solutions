class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n];
        long[] prefixBack = new long[n];
        prefixBack[n-1] = nums[n-1];
        prefix[0] = nums[0];
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
        for(int i=n-2;i>=0;i--) prefixBack[i] = prefixBack[i+1] + nums[i];
        int ans = 0;
        for(int i=0;i<n-1;i++)
            if(prefix[i]>=prefixBack[i+1]) ans++;
        return ans;
    }
}
