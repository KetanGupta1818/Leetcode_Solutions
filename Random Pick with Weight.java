class Solution {
    int n;
    int[] prefixSum;
    Random random;
    public Solution(int[] w) {
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for(int i=1;i< w.length;i++) prefixSum[i] = prefixSum[i-1]+w[i];
        random = new Random();
        n = prefixSum.length;
    }

    public int pickIndex() {
        if(prefixSum.length == 1) return 0;
        int target = random.nextInt(prefixSum[n-1])+1;
        int lo=0,hi=prefixSum.length-1;
        while(lo<=hi){
            int m = (lo+hi)>>1;
            if(prefixSum[m] == target) return m;
            else if(prefixSum[m] < target) lo=m+1;
            else hi=m-1;
        }
        return hi+1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
