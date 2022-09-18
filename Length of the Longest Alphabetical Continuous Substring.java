class Solution {
    public int longestContinuousSubstring(String s) {
        int max = 1,prev=-2,cur=0;
        for(int i=0;i<s.length();i++){
            int c = s.charAt(i)-'a';
            if(c==prev+1){
                cur++;
                max = Math.max(max,cur);
            }
            else cur=1;
            prev = c;
        }
        return max;
    }
}
