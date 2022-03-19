class Solution {
    public int strStr(String TS, String PS) {
        if(PS.isEmpty()) return 0;
        char[] P = PS.toCharArray();
        char[] T = TS.toCharArray();
        int[] lps = new int[P.length];
        int i=1,j=0;
        while(i<P.length){
            if(P[i]==P[j]){
                lps[i]=j+1;
                i++;
                j++;
            }
            else if(j>0) j=lps[j-1];
            else i++;
        }
        i=0;j=0;
        while(i<T.length){
            if(T[i]==P[j]){
                if(j==P.length-1) return i-j;
                else{
                    i++;
                    j++;
                }
            }
            else if(j>0) j=lps[j-1];
            else i++;
        }
        return -1;
    }
}
