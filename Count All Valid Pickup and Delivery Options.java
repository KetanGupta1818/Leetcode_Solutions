class Solution {
    public int countOrders(int n) {
        long r=1;
        for(int i=2;i<=n;i++) r = (i*((i-1)*2+1)*r)%1_000_000_007;
        return (int)r;
    }
}
