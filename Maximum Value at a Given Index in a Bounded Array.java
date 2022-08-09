class Solution {
    public int maxValue(int n, int index, int maxSum) {
        long lo=1,hi=maxSum;
        while(lo <= hi){
            long m = (lo+hi)>>1L;
            if(fun((long)index,m,(long)n,(long)maxSum)) lo=m+1;
            else hi=m-1;
        }
        return (int)(lo-1);
    }
    private boolean fun(long index, long m, long n, long maximalSum){
        if(m==0) return false;
        long sum = (long)m--;
        long rs = n-index-1;
        if(index>m) sum = sum + index-m + m*(m+1)/2;
        else sum = sum + m*(m+1)/2 - (m-index)*(m-index+1)/2;
        if(rs>m) sum = sum + rs-m + m*(m+1)/2;
        else sum = sum + m*(m+1)/2 - (m-rs)*(m-rs+1)/2;
        return sum<=maximalSum;
    }
}
