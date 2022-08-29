class Solution {
    private static final long MOD = 1_000_000_007L;
    public int countGoodNumbers(long n) {
        return (int)(modPow(5,(long)Math.ceil(n/2.0))*modPow(4,n/2)%MOD);
    }
    private long modPow(long a, long n){
        a=a%MOD;
        long res = 1L;
        while(n>0){
            if((n&1)==1) res=a*res%MOD;
            a=a*a%MOD;
            n=n>>1;
        }
        return res%MOD;
    }
}
