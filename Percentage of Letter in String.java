class Solution {
    public int percentageLetter(String s, char letter) {
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++) freq[s.charAt(i)-'a']++;
        return (int)Math.floor(((freq[letter-'a']*1.0)/s.length())*100);
    }
}
