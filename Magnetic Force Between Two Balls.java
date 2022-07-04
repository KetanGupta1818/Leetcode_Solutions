class Solution {
    public int maxDistance(int[] p, int total_balls) {
        Arrays.sort(p);
        int lo=1,hi=p[p.length-1];
        while(lo <= hi){
            int m = lo + (hi - lo)/2;
            if(isDistanceValid(p,total_balls,m)) lo = m+1;
            else hi = m-1;
        }
        return lo-1;
    }
    private boolean isDistanceValid(int[] p, int m, int dis){
        int balls = 1;
        int last_index = 0;
        for(int i=1;i<p.length;i++) {
            if(p[i] - p[last_index] >= dis){
                last_index = i;
                balls++;
            }
        }
        return balls>=m;
    }
}
