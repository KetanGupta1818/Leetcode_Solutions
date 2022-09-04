/*
    Draw a table where cols are steps and rows are positions on x axis. 
    It will turn out to be values of nCr table
    Without drawing the table its not possible to understand this solution
*/
class Solution {
    private static final Combinatorics combinatorics = new Combinatorics(1001);
    public int numberOfWays(int startPos, int endPos, int k) {
        endPos -= startPos;
        if((endPos%2==0 && k%2==1) || (endPos%2==1 && k%2==0) || endPos>k) return 0;
        return (int)(combinatorics.C(k,(k-endPos)/2)%1_000_000_007);
    }
}
class Combinatorics{
    private static final long MOD = 1_000_000_007;
    long[] fac;

    public Combinatorics(int n){
        this.fac = new long[n+1];
        fac[0] = 1L;
        for(int i=1;i<=n;i++) fac[i] = fac[i-1]*i%MOD;
    }

    private long powMod(long x, long n){
        if(n == 0) return 1L;
        long t = powMod(x,n/2);
        if(n%2 == 0) return t*t%MOD;
        return t*t%MOD*x%MOD;
    }

    public long C(int n,int r){
        return (fac[n]*powMod(fac[n-r]*fac[r]%MOD,MOD-2))%MOD;
    }
}
