class Solution {
    public int bitwiseComplement(int n) {
        int result = 0;
        int i=0;
        if(n==0) return 1;
        while(n>0){
            if((n&1)==0){
                int val = 1<<i;
                result+=val;
            }
            n=n>>1;
            i++;
        }
        return result;
    }
}
