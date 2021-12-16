class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n+1][Math.max(k+1,target+1)];
        for(int i=1;i<=k;i++){
            dp[1][i]=1;
        }
        int MOD = (int)Math.pow(10, 9) + 7;
        for(int dice=2;dice<=n;dice++){
            for(int curTarget=1;curTarget<=target;curTarget++){
                int i=0;
                int index=curTarget-1;
                while(index>=1 && i<k){
                    i++;
                    dp[dice][curTarget] = (dp[dice][curTarget] + dp[dice-1][index])%MOD;
                    index--;
                }
            }
        }
        return dp[n][target];
    }
}
