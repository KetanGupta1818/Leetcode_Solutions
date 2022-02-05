class Solution {
    public int numberWays(List<List<Integer>> hats) {
        int numberOfPeople = hats.size();
        int[][] dp = new int[41][1025];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++) dp[i][j]=-1;
        }
        List<Integer>[] h2p = new List[41];
        for(int i=1;i<41;i++) h2p[i] = new ArrayList<>();
        for(int person=0;person<numberOfPeople;person++){
            for(int hatNumber: hats.get(person)){
                h2p[hatNumber].add(person);
            }
        }
        return dfs(h2p,(1<<numberOfPeople)-1,1,0,dp);
    }
    public int dfs(List<Integer>[] h2p, int allMask,int hatNumber,int selectedPeople,int[][] dp){
        if(selectedPeople==allMask) return 1;
        if(hatNumber>40) return 0;
        if(dp[hatNumber][selectedPeople]!=-1) return dp[hatNumber][selectedPeople];
        int ways = dfs(h2p,allMask,hatNumber+1,selectedPeople,dp);
        for(int person: h2p[hatNumber]){
            if(((selectedPeople>>person)&1)==1) continue;
            ways+=dfs(h2p,allMask,hatNumber+1,(selectedPeople|(1<<person)),dp);
            ways%=1_000_000_007;
        }
        return dp[hatNumber][selectedPeople]=ways;
    }
}
