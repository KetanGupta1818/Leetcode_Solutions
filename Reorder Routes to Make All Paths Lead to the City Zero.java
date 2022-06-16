class Solution {
     public int minReorder(int n, int[][] connections) {
        List<HashSet<Integer>> set = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) {
            set.add(new HashSet<>());
            graph.add(new ArrayList<>());
        }
        for(int[] con: connections) {
            set.get(con[0]).add(con[1]);
            graph.get(con[0]).add(con[1]);
            graph.get(con[1]).add(con[0]);
        }
        return dfs(0,set,graph,new boolean[n]);
    }
    private int dfs(int node, List<HashSet<Integer>> set, List<List<Integer>> graph, boolean[] visited){
        int changes = 0;
        visited[node] = true;
        for(int child: graph.get(node)){
            if(visited[child]) continue;
            if(set.get(node).contains(child)) changes++;
            changes += dfs(child,set,graph,visited);
        }
        return changes;
    }
}
