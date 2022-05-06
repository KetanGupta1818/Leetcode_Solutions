class Solution {
    public int mySqrt(int x) {
        int lo=0,hi=46340;
        while(lo<=hi){
            int m=lo+(hi-lo)/2;
            if(x==m*m) return m;
            else if(x>m*m) lo=m+1;
            else hi=m-1;
        }
        return lo-1;
    }
}
