class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long[] ps = new long[n];
        ps[0] = (long)chalk[0];
        for(int i=1;i<n;i++) ps[i] = ps[i-1]+chalk[i];
        k = (int)((long)k%ps[n-1]);
        return bs(ps,k);
    }
    private int bs(long[] ps, int k){
        int lo=0,hi=ps.length-1;
        while(lo<=hi){
            int m = (lo+hi)/2;
            if(ps[m] <= k) lo = m+1;
            else hi = m-1;
        }
        return lo;
    }
}
