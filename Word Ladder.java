class Solution {
   public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> setOfWords = new ConcurrentSkipListSet<>(wordList);
        setOfWords.add(beginWord);
        int transformations = 0;
        if(!setOfWords.contains(endWord)) return transformations;
        Queue<String> queue = new ArrayDeque<>();
        transformations++;
        queue.offer(beginWord);
        setOfWords.remove(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String currentString = queue.poll();
                for(String string: setOfWords){
                    if(oneLetterDifferent(currentString,string)){
                        if(string.equals(endWord)) return transformations+1;
                        setOfWords.remove(string);
                        queue.offer(string);
                        
                    }
                }
            }
            transformations++;
        }
        return 0;
    }
    public boolean oneLetterDifferent(String a, String b){
        int diff = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)) diff++;
            if(diff>1) return false;
        }
        return diff==1;
    }
}
