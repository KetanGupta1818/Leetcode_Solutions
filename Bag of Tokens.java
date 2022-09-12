class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int max = 0,score=0,lp=0,rp=tokens.length-1,n=tokens.length;
        Arrays.sort(tokens);
        while(lp<=rp){
            if(power>=tokens[lp]){
                score++;
                power-=tokens[lp];
                max=Math.max(score,max);
                lp++;
            }
            else {
                if(score>=1){
                    score--;
                    power+=tokens[rp];
                }
                rp--;
            }
        }
        return max;
    }
}
