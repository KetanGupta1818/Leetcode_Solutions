class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int lgpt = (int)Math.floor(Math.log(left)/Math.log(2));
        int rgpt = (int)Math.floor(Math.log(right)/Math.log(2));
        int answer = 0;
        for(int i=0;i<=rgpt;i++) {
            int pt = 1<<i;
            if((left/pt == right/pt) && (left/pt)%2==1) answer += 1<<i;
        }
        return answer;
    }
}
