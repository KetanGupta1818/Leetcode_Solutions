class Solution {
    public int hIndex(int[] c) {
        int lo=0,hi=c.length-1,len=c.length;
        while(lo<=hi){
            int m = (lo+hi)>>1;
            if(c[m]==len-m) return c[m];
            else if(c[m]>len-m) hi=m-1;
            else lo=m+1;
        }
        return len-lo;
    }
}
