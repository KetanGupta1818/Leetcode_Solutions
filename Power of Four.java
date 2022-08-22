class Solution {
    public boolean isPowerOfFour(int n) {
        if((n&(n-1))!=0) return false;
        int i=0;
        while(n!=0){
            i++;
            n=n>>1;
        }
        return i%2==1;
    }
}
