class Solution {
    public int longestSubsequence(String s, int k) {
        int zeros = 0;
        for(int i=0;i<s.length();i++) if(s.charAt(i) == '0') zeros++;
        int val=0,pow=1;
        for(int i=s.length()-1;i>=0;i--){
            if(val+pow>k) break;
            if(s.charAt(i) == '1'){
                val+=pow;
                zeros++;
            }
            pow = pow << 1;
        }
        return zeros;
    }
}
