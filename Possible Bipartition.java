class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] colors = new int[n];
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int[] edge: dislikes){
            int u = edge[0]-1;
            int v = edge[1]-1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        for(int i=0;i<n;i++){
            if(colors[i]==0 && !isBipartite(graph,colors,1,i)) return false;
        }
        return true;
    }
    private boolean isBipartite(List<List<Integer>> graph, int[] colors, int color, int node){
        colors[node] = color;
        boolean res = true;
        for(int child: graph.get(node)){
            if(colors[child]==color) return false;
            if(colors[child]==0) res = res && isBipartite(graph,colors,color*(-1),child);
        }
        return res;
    }
}
