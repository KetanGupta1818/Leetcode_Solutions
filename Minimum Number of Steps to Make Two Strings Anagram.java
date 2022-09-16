class Solution {
    public int minSteps(String s, String t) {
        int[] m = new int[26];
        for(int i=0;i<s.length();i++){
            m[s.charAt(i)-'a']++;
            m[t.charAt(i)-'a']--;
        }
        int cnt=0;
        for(int v: m){
            if(v>0) cnt+=v;
            if(v<0) cnt+=(-1*v);
        }
        return cnt/2;
    }
}
