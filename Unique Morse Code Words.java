class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] map = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for(String w: words){
            String cur = "";
            for(int i=0;i<w.length();i++)
                cur = cur+map[w.charAt(i)-'a'];
            set.add(cur);
        }
        return set.size();
    }
}
