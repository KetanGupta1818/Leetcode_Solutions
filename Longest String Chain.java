class Solution {
    public int longestStrChain(String[] words) {
        List<HashSet<String>> mapOfWords = new ArrayList<>();
        Map<String,Integer> inDegree = new HashMap<>();
        for(int i=0;i<=16;i++) mapOfWords.add(new HashSet<>());
        for(String word: words){
            mapOfWords.get(word.length()).add(word);
            inDegree.put(word,0);
        }
        Map<String,List<String>> graph = new HashMap<>();
        for(int i=1;i<16;i++) {
            HashSet<String> setOfNextWords = mapOfWords.get(i+1);
            for(String word: mapOfWords.get(i)){
                graph.put(word,new ArrayList<>());
                for(String nextWord: setOfNextWords){
                    if(isPredecessor(word,nextWord)) {
                        List<String> list = graph.get(word);
                        list.add(nextWord);
                        graph.put(word,list);
                        inDegree.put(nextWord,inDegree.get(nextWord)+1);
                    }
                }
            }
        }
        for(String longestWord: mapOfWords.get(16)) graph.put(longestWord,new ArrayList<>());
        Queue<String> queue = new ArrayDeque<>();
        for(String string: inDegree.keySet()){
            if(inDegree.get(string)==0) queue.offer(string);
        }
        int depth = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int s=0;s<size;s++){
                String cur = queue.remove();
                List<String> successorList = graph.get(cur);
                for(String successor: successorList){
                    inDegree.put(successor,inDegree.get(successor)-1);
                    if(inDegree.get(successor) == 0) queue.offer(successor);
                }
            }
            depth++;
        }
        return depth-1;
    }
    private boolean isPredecessor(String pre, String target){
        for(int i=0;i<target.length();i++) if((target.substring(0,i)+target.substring(i+1)).equals(pre)) return true;
        return false;
    }

}
