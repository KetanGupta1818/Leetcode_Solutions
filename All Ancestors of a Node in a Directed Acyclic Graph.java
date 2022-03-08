class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        int[] inDegrees = new int[n];
        for(int[] edge: edges) inDegrees[edge[1]]++;
        Queue<Integer> queue = new ArrayDeque<>();
        for(int v=0;v<n;v++){
            if(inDegrees[v]==0) queue.offer(v);
        }
        List<Set<Integer>> ancestors = new ArrayList<>();
        for(int i=0;i<n;i++) ancestors.add(new HashSet<>());
        List<List<Integer>> edgeList = new ArrayList<>();
        for(int i=0;i<n;i++) edgeList.add(new ArrayList<>());
        for(int[] edge: edges) edgeList.get(edge[0]).add(edge[1]);
        while(!queue.isEmpty()){
            int v = queue.poll();
            List<Integer> nextVertices = edgeList.get(v);
            for(int nextVertex: nextVertices){
                ancestors.get(nextVertex).addAll(ancestors.get(v));
                ancestors.get(nextVertex).add(v);
                inDegrees[nextVertex]--;
                if(inDegrees[nextVertex]==0) queue.offer(nextVertex);
            }
        }
        List<List<Integer>> answer = new ArrayList<>();
        for(Set<Integer> set: ancestors){
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            answer.add(list);
        }
        return answer;
    }
}
