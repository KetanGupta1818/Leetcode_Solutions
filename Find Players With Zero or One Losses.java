class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int maxValue = Integer.MIN_VALUE;
        Set<Integer> visited = new HashSet<>();
        for(int[] match: matches){
            visited.add(match[0]);
            visited.add(match[1]);
            maxValue = Math.max(maxValue,Math.max(match[0],match[1]));
        }
        int[] inDegrees = new int[maxValue+1];
        for(int[] match: matches){
            inDegrees[match[1]]++;
        }
        List<Integer> noMatchLost = new ArrayList<>();
        List<Integer> oneMatchLost = new ArrayList<>();
        for(int i=0;i<inDegrees.length;i++){
            if(inDegrees[i]==0 && visited.contains(i)) noMatchLost.add(i);
            if(inDegrees[i]==1) oneMatchLost.add(i);
        }
        return List.of(noMatchLost,oneMatchLost);
    }
}
