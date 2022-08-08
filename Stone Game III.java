class Solution {
    public String stoneGameIII(int[] sv) {
        int n = sv.length; 
        int[] dp1 = new int[n+1]; //Maximum sum of player who picks this stone
        int[] dp2 = new int[n+1]; // Maximum sum of player who does not pick this stone. 
        dp1[n-1] = sv[n-1];
        for(int i=n-2;i>=0;i--){
            dp1[i] = sv[i]+dp2[i+1];
            dp2[i] = dp1[i+1];
            if(dp1[i] < sv[i]+sv[i+1]+dp2[i+2]){
                dp1[i] = sv[i]+sv[i+1]+dp2[i+2];
                dp2[i] = dp1[i+2];
            }
            if(i <= n-3){
                if(dp1[i] < sv[i]+sv[i+1]+sv[i+2]+dp2[i+3]){
                    dp1[i] = sv[i]+sv[i+1]+sv[i+2]+dp2[i+3];
                    dp2[i] = dp1[i+3];
                }
            }
        }
        if(dp1[0]>dp2[0]) return "Alice";
        else if(dp1[0]<dp2[0]) return "Bob";
        return "Tie";
    }
}
