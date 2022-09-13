class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<HashSet<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new HashSet<>());
        int[] degree= new int[n];
        for(int[] road: roads){
            int u = road[0];
            int v = road[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            degree[v]++;
            degree[u]++;
        }
        int answer = 0;
        for(int vertex=0;vertex<n;vertex++){
            for(int nv=0;nv<n;nv++){
                if(vertex==nv) continue;
                if(graph.get(vertex).contains(nv)) answer = Math.max(answer,degree[vertex]+degree[nv]-1);
                else answer = Math.max(answer,degree[vertex]+degree[nv]);
            }
        }
        return answer;
    }
}
