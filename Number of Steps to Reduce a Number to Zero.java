class Solution {
    public int numberOfSteps(int num) {
       int counter = 0;
        while(num>0){
            if((num&1) == 1) counter+=2;
            else counter++;
            num>>=1;
        }
        return Math.max(0,counter-1);
    }
}
