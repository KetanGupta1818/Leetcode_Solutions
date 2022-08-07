class Solution {
    public int longestIdealString(String s, int k) {
        int[] map = new int[26];
        int answer = 1;
        for(int i=s.length()-1;i>=0;i--){
            int c = s.charAt(i)-'a';
            int m = 1;
            for(int p=0;p<=25;p++){
                if(Math.abs(p-c)<=k) m = Math.max(map[p]+1,m);
            }
            answer = Math.max(map[c]=m,answer);
        }
        return answer;
    }
}
