class Solution {
    public String greatestLetter(String s) {
        int[] upper = new int[26];
        int[] lower = new int[26];
        for(int i=0;i<s.length();i++){
            int c = s.charAt(i) - 'a';
            if(c<0) upper[s.charAt(i)-'A']++;
            else lower[c]++;
        }
        for(int i=25;i>=0;i--){
            if(upper[i]>0&&lower[i]>0) {
                char c = (char)(i+65);
                return Character.toString(c);
            }
        }
        return "";
    }
}
