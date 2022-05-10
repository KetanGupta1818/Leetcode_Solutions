class Solution {
    public boolean judgeSquareSum(int c) {
        for(int i=0;i*i<=c/2;i++) if(bs(c-i*i,(int)Math.sqrt(c))) return true;
        return false;
    }
    private boolean bs(int target,int hi){
        int lo=0;
        while(lo<=hi){
            int m = lo+(hi-lo)/2;
            if(m*m == target) return true;
            else if(m*m>target) hi=m-1;
            else lo=m+1;
        }
        return false;
    }
}
