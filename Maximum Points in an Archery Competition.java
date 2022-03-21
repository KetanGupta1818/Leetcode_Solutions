class Solution {
    int[] maxBob = new int[12];
    int maxPoints = 0;
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[] bob = new int[12];
        fun(aliceArrows,bob,numArrows,11,0);
        return maxBob;
    }
    public void fun(int[] alice, int[] bob, int numArrows, int index, int points){
        if(index<0 || numArrows<=0){
            if(numArrows>0) bob[0]+=numArrows;
            if(maxPoints<points){
                maxPoints=points;
                for(int i=0;i<12;i++){
                    maxBob[i] = bob[i];
                }
            }
            return;
        }
        if(numArrows>alice[index]){
            bob[index] = alice[index]+1;
            fun(alice,bob,numArrows-alice[index]-1,index-1,points+index);
        }
        bob[index]=0;
        fun(alice,bob,numArrows,index-1,points);
        bob[index]=0;
        
    }
}
