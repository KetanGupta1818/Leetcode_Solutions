class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> edges = new ArrayList<>();
        for(int i=0;i< graph.length;i++) edges.add(new ArrayList<>());
        for(int i=0;i< graph.length;i++) {
            int[] outgoingEdges = graph[i];
            for(int v: outgoingEdges){
                edges.get(v).add(i);
            }
        }
        int[] inDegree = new int[graph.length];
        for(List<Integer> outEdges: edges) for(int v: outEdges) inDegree[v]++;
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.length];
        for(int i=0;i< inDegree.length;i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
                visited[i] = true;
            }
        }
        while (!queue.isEmpty()){
            int cur = queue.remove();
            for(int nextVertex: edges.get(cur)) {
                inDegree[nextVertex]--;
                if(inDegree[nextVertex] == 0){
                    queue.offer(nextVertex);
                    visited[nextVertex] = true;
                } 
            }
        }
        List<Integer> answer = new ArrayList<>();
        for(int i=0;i< graph.length;i++) if(visited[i]) answer.add(i);
        return answer;
    }
}
