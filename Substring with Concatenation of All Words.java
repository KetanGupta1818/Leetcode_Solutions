class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String,Integer> mapOfWords = new HashMap<>();
        for(String word: words) mapOfWords.put(word,mapOfWords.getOrDefault(word,0)+1);
        int k = words[0].length();
        int n = words.length*k;
        int sLen = s.length();
        if(sLen<n) return answer;
        int[] arr = new int[26];
        for(String word: words){
            for(int i=0;i<k;i++){
                arr[word.charAt(i)-'a']++;
            }
        }
        int start=0,end=n-1;
        for(int i=0;i<=end;i++) arr[s.charAt(i)-'a']--;
        while(end<s.length()-1){
            if(allZeros(arr)&&validWords(s.substring(start,end+1),new HashMap<>(mapOfWords),k)) answer.add(start);
            arr[s.charAt(start)-'a']++;
            start++;end++;
            arr[s.charAt(end)-'a']--;
        }
        if(allZeros(arr)&&validWords(s.substring(start,end+1),new HashMap<>(mapOfWords),k)) answer.add(start);
        return answer;
    }
    public boolean allZeros(int[] arr){
        return Arrays.stream(arr).allMatch(i->i==0);
    }
    public boolean validWords(String s, HashMap<String,Integer> mapOfWords, int k){
        for(int i=0;i*k<s.length();i++){
            String currentString = s.substring(i*k,(i+1)*k);
            if(mapOfWords.containsKey(currentString)){
                mapOfWords.put(currentString,mapOfWords.get(currentString)-1);
                if(mapOfWords.get(currentString)<0) return false;
            }
            else return false;
        }
        return true;
    }
}
