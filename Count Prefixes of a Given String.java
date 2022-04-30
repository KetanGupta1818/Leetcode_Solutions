class Solution {
    public int countPrefixes(String[] words, String s) {
        Set<String> prefixSet = new HashSet<>();
        for(int i=1;i<=s.length();i++){
            prefixSet.add(s.substring(0,i));
        }
        int counter = 0;
        for(String word: words) if(prefixSet.contains(word)) counter++;
        return counter;
    }
}
