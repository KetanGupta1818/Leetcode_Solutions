class Solution {
    public int minSwaps(String S) {
        char[] s = S.toCharArray();
        int ones=0,zeros=0;
        for (char c : s) {
            if (c == '1') ones++;
            else zeros++;
        }
        int a = zeroOneString(s,ones,zeros);
        int b = oneZeroString(s,ones,zeros);
        if(a==-1) return b;
        if(b == -1) return a;
        return Math.min(a,b);
    }
    private int zeroOneString(char[] s,int ones, int zeros){
        int n = s.length;
        char[] alt = new char[n];
        for(int i=0;i<n-n%2;i+=2){
            alt[i] = '0';
            alt[i+1] = '1';
            ones--;
            zeros--;
        }
        if(n%2==1) {
            alt[n-1] = '0';
            zeros--;
        }
        
        if(zeros!=0 || ones!=0) return -1;
        int changes = 0;
        for(int i=0;i<n;i++) if(alt[i]!=s[i]) changes++;
        return changes/2;
    }
    private int oneZeroString(char[] s,int ones, int zeros){
        int n = s.length;
        char[] alt = new char[n];
        for(int i=0;i<n-n%2;i+=2){
            alt[i+1] = '0';
            alt[i] = '1';
            ones--;
            zeros--;
        }
        if(n%2==1) {
            alt[n-1] = '1';
            ones--;
        }
        if(zeros!=0 || ones!=0) return -1;
        int changes = 0;
        for(int i=0;i<n;i++) if(alt[i]!=s[i]) changes++;
        return changes/2;
    }
}
