class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int xr = startPos[0];
        int yr = startPos[1];
        int xh = homePos[0];
        int yh = homePos[1];
        int cost = 0;
        while(xr!=xh){
            if(xh>xr) cost+=rowCosts[++xr];
            else cost+=rowCosts[--xr];
        }
        while(yr!=yh){
            if(yh>yr) cost+=colCosts[++yr];
            else cost+=colCosts[--yr];
        }
        return cost;
    }
}
