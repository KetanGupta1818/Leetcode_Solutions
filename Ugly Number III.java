class Solution {
    public long getGCD(long x, long y){
        long a = Math.max(x,y);
        long b = Math.min(x,y);

        while(b != 0){
            long temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
    private long lcm(long n1,long n2){
        return (n1*n2)/getGCD(n1,n2);
    }
    public int nthUglyNumber(int nn, int aa, int bb, int cc) {
        long a = aa;
        long b = bb;
        long c = cc;
        long n = nn;
        long lo=0,hi=Integer.MAX_VALUE;
        while(lo<=hi){
            long m = lo+(hi-lo)/2;
            long nums = m/a+m/b+m/c+m/lcm(a,lcm(b,c))-m/lcm(a,b)-m/lcm(a,c)-m/lcm(b,c);
            if(nums>=n) hi=m-1;
            else lo=m+1;
        }
        return (int)lo;
    }
}
