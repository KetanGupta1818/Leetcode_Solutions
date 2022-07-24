class Solution {
    public char repeatedCharacter(String s) {
        int[] map = new int[26];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map[c-97]++;
            if(map[c-97]==2) return c;
        }
        return ' ';
    }
}
