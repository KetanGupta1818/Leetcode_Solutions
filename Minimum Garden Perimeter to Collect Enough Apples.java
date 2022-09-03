class Solution {
    public long minimumPerimeter(long neededApples) {
        long apple = 0L;
        int i=0;
        while(apple<neededApples){
            i++;
            apple += (3*i+sumInRange(2*i-1,i)*2)*4;
        }
        return 8L*i;
    }
    private long sumInRange(long left, long right){
        long lower = right*(right+1)/2;
        long higher = left*(left+1)/2;
        return higher-lower;
    }
}
