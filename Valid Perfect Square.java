class Solution {
    public boolean isPerfectSquare(int num) {
        int lo=0,hi=46341;
        while(lo<=hi){
            int m = lo + (hi - lo)/2;
            int d = dif(num,m);
            if(d==0) return true;
            else if(d>0) lo = m + 1;
            else hi = m -1;
        }
        return false;
    }
    private int dif(int num, int sq){
        return num - sq*sq;
    }
}
