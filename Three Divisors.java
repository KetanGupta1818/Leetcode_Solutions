class Solution {
    public boolean isThree(int n) {
        int c = 0;
        for(int i=n;i>0;i--) if(n%i==0) c++;
        return c==3;
    }
}
