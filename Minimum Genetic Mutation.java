class Solution {
    public int minMutation(String start, String end, String[] bk) {
        Map<String,List<String>> wordsToTheirNeighbors = new HashMap<>();
        for(String b: bk) wordsToTheirNeighbors.put(b,new ArrayList<>());
        wordsToTheirNeighbors.put(start,new ArrayList<>());
        for(String word: wordsToTheirNeighbors.keySet()){
            for(String neighbor: bk){
                if(neighbor.equals(word)) continue;
                if(differByOne(word,neighbor)){
                    List<String> list = wordsToTheirNeighbors.get(word);
                    list.add(neighbor);
                    wordsToTheirNeighbors.put(word,list);
                }
            }
        }
        HashSet<String> visited = new HashSet<>();
        visited.add(start);
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);
        int operations = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int s=0;s<size;s++){
                String cur = queue.poll();
                if(cur.equals(end)) return operations;
                for(String child: wordsToTheirNeighbors.get(cur)){
                    if(!visited.contains(child)){
                        visited.add(child);
                        queue.offer(child);
                    }
                }
            }
            operations++;
        }
        return -1;
    }
    private boolean differByOne(String first, String second){
        int dif = 0;
        for(int i=0;i<8;i++){
            if(first.charAt(i)!=second.charAt(i)) dif++;
        }
        return dif==1;
    }
}
