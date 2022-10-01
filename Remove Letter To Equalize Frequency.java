class Solution {
     public boolean equalFrequency(String word) {
        int maxIndex = -1;
        int max = 0;
        int[] map = new int[26];
        for(int i=0;i<word.length();i++) map[word.charAt(i)-'a']++;
        for(int i=0;i<26;i++){
            if(map[i]==0) continue;
            map[i]--;
            if(f(map)) return true;
            map[i]++;
        }
        return false;
    }
    private boolean f(int[] map){
        int prev = -1;
        for(int m: map){
            if(m == 0 || m==prev) continue;
            if(prev == -1) prev = m;
            else return false;
        }
        return true;
    }
}
