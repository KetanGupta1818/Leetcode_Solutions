class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long lo=1,hi=100_000_000_000_000L;
        long mid = 1L;
        while(lo<hi){
            mid = lo + (hi-lo)/2;
            long curTrips = numberOfTrips(time,mid);
            if(curTrips>=totalTrips) hi=mid;
            else lo = mid+1;
        }
        return lo;
        
    }
    public long numberOfTrips(int[] time, long curTime){
        long n = 0;
        for(int t: time){
            n+=curTime/t;
        }
        
        return n;
    }
}
