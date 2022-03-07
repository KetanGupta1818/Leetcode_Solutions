class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }
         l: for(int i=0;i<words.length-1;i++){
            String smallerWord = words[i];
            String greaterWord = words[i+1];
            int si = 0;
            int li = 0;
            while(si<smallerWord.length() && li<greaterWord.length()){
                char smallerCharacter = smallerWord.charAt(si);
                char greaterCharacter = greaterWord.charAt(li);
                if(map.get(smallerCharacter)<map.get(greaterCharacter)) continue l;
                if(map.get(smallerCharacter)>map.get(greaterCharacter)) return false;
                si++;
                li++;
            }
            if(si<smallerWord.length()) return false;
        }
        return true;
    }
}
