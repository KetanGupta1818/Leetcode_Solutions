class Solution {
    public int minMoves(int target, int maxDoubles) {
        int moves = 0;
        if(maxDoubles==0) return target-1;
        while(maxDoubles>0 && target!=1){
            if(target%2==1) target--;
            else {
                target/=2;
                maxDoubles--;
            }
            moves++;
        }
        while (target!=1) {
            target--;
            moves++;
        }
        return moves;
    }
}
