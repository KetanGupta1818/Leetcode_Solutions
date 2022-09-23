class Solution {
    static long[] powersOfTwo = new long[1568946];
    static private final long MOD = 1_000_000_007L;
    static {
        powersOfTwo[0] = 1;
        for(int i=1;i<powersOfTwo.length;i++) powersOfTwo[i] = (powersOfTwo[i-1]*2)%MOD;
    }
    public int concatenatedBinary(int n) {
        StringBuilder num = new StringBuilder();
        for(int i=1;i<=n;i++) num.append(Integer.toBinaryString(i));
        num.reverse();
        long res = 0;
        for(int i=0;i<num.length();i++) 
            res = (res + (num.charAt(i)-'0')*powersOfTwo[i])%MOD;
        return (int) res;
    }
}
