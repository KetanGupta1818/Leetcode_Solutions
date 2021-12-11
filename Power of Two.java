class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        int n1 = n&(n-1);
        return n1 == 0;
    }
}
