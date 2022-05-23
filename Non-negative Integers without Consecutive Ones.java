class Solution {
    public int findIntegers(int n) {
        int[] dp = new int[32];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2;i<dp.length;i++) dp[i] = dp[i-1] + dp[i-2];
        int i=31,sum=0,prev_bit=0;
        while(i>=0){
            if((n&(1<<i))!=0){
                sum+=dp[i];
                if(prev_bit == 1){
                    sum--;
                    break;
                }
                prev_bit = 1;
            }
            else prev_bit = 0;
            i--;
        }
        return sum+1;
    }
}
