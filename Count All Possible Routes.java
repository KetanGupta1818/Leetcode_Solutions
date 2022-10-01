**Recursion**
```
class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        if(fuel<0) return 0;
        int ways = start==finish?1:0;
        for(int i=0;i<locations.length;i++){
            if(i == start) continue;
            ways += countRoutes(locations,i,finish,fuel-Math.abs(locations[i]-locations[start]));
        }
        return ways;
    }
}
```


**DP**

```
class Solution {
    private static final int MOD = 1_000_000_007;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        long[][] dp = new long[locations.length][fuel+1];
        for(int i=0;i<locations.length;i++) for(int j=0;j<=fuel;j++) dp[i][j] = -1L;
        return (int)f(locations,start,finish,fuel,dp);
    }
    public long f(int[] locations, int start, int finish, int fuel,long[][] dp) {
        if(fuel<0) return 0L;
        if(dp[start][fuel]!=-1L) return dp[start][fuel];
        long ways = start==finish?1L:0L;
        for(int i=0;i<locations.length;i++){
            if(i == start) continue;
            ways = (ways+f(locations,i,finish,fuel-Math.abs(locations[i]-locations[start]),dp))%MOD;;
        }
        return dp[start][fuel] = ways;
    }
}
```
