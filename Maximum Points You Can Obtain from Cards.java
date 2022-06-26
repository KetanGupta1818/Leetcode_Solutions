class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length,max=0;
        int[] ps1 = new int[n];
        int[] ps2 = new int[n];
        ps1[0] = cardPoints[0];
        ps2[n-1] = cardPoints[n-1];
        for(int i=1;i<n;i++) ps1[i] = ps1[i-1]+cardPoints[i];
        for(int i=n-2;i>=0;i--) ps2[i] = ps2[i+1]+cardPoints[i];
        max = Math.max(ps1[k-1],ps2[n-k]);
        int bi=n-1;
        for(int i=k-2;i>=0;i--){
            max = Math.max(max,ps1[i]+ps2[bi--]);
        }
        return max;
    }
}
