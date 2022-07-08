class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        Integer[][][] dp = new Integer[m][n+1][target+1];
        int min_cost = fun(0,0,n,houses,cost,0,target,dp);
        return min_cost == 1000_00000 ? -1: min_cost;
    }
    private int fun(int house_number, int prev_color, int numberOfColors, int[] houses, int[][] cost,
                    int cur_neighborhoods, int target,Integer[][][] dp){
        if(house_number == houses.length){
            if(cur_neighborhoods != target) return 1_000_00000;
            return 0;
        }
        if(cur_neighborhoods > target) return 1_000_00000;
        if(dp[house_number][prev_color][cur_neighborhoods]!=null) return dp[house_number][prev_color][cur_neighborhoods];
        if(houses[house_number] != 0){
            int newNeighborhoods = cur_neighborhoods;
            if(prev_color != houses[house_number]) newNeighborhoods++;
            int minimumCost = fun(house_number+1,houses[house_number],numberOfColors,houses,cost,newNeighborhoods,target,dp);
            return dp[house_number][prev_color][cur_neighborhoods] = minimumCost;
        }
        int min_cost = 1_000_00000;
        for(int color=1;color<=numberOfColors;color++){
            int newNeighborhoods = cur_neighborhoods;
            if(prev_color != color) newNeighborhoods++;
            min_cost = Math.min(min_cost,fun(house_number+1,color,numberOfColors,houses,cost,newNeighborhoods,target,dp)+cost[house_number][color-1]);
        }
        return dp[house_number][prev_color][cur_neighborhoods] = min_cost;
    }
}
