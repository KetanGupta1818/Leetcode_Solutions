class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        int[][] dp = new int[n+1][n];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) map.put(stones[i],i);
        return fun(dp,stones,map,0,1) == 1;
    }
    private int fun(int[][] dp, int[] stones, Map<Integer,Integer> map, int index, int k){
        if(index == stones.length-1) return 1;
        if(dp[k][index] != 0) return dp[k][index];
        int res = -1;
        int stone_value = stones[index];
        if(index!=0 && map.containsKey(stone_value+k+1)) res = Math.max(res,fun(dp,stones,map,map.get(stone_value+k+1),k+1));
        if(map.containsKey(stone_value+k)) res = Math.max(res,fun(dp,stones,map,map.get(stone_value+k),k));
        if(k>1 && map.containsKey(stone_value+k-1)) res = Math.max(res,fun(dp,stones,map,map.get(stone_value+k-1),k-1));
        return dp[k][index] = res;
    }
}
