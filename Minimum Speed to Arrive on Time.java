class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int lo=1,hi=1000_0000;
        if(hour<=dist.length-1) return -1;
        int ans = 0;
        while(lo <= hi){
            int m = lo + (hi - lo)/2;
            if(bs(dist,m,hour)) hi=m-1;
            else lo=m+1;
        }
        return hi+1;
    }
    private boolean bs(int[] dist, int speed, double hour){
        double t=0;
        for(int i=0;i<dist.length-1;i++) t += Math.ceil(((double)dist[i])/speed);
        t += ((double)dist[dist.length-1])/speed;
        return t<=hour;
    }
}
