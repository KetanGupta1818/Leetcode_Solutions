class Solution {
    private static int TIME=0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> answer = new ArrayList<>();
        int[] entry_time = new int[n];
        int[] oldest_reachable_ancestor = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(List<Integer> con: connections){
            graph.get(con.get(0)).add(con.get(1));
            graph.get(con.get(1)).add(con.get(0));
        }
        for(int i=0;i<n;i++){
            if(entry_time[i] == 0){
                dfs(i,i,answer,entry_time,oldest_reachable_ancestor,graph);
            }
        }
        return answer;
    }
    private void dfs(int u, int p, List<List<Integer>> answer, int[] entry_time, int[] oldest_reachable_ancestor,List<List<Integer>> graph){
        entry_time[u] = oldest_reachable_ancestor[u] = ++TIME;
        for(int v: graph.get(u)){
            if(v == p) continue;
            if(entry_time[v] == 0){
                dfs(v,u,answer,entry_time,oldest_reachable_ancestor,graph);
                if(entry_time[u] < oldest_reachable_ancestor[v]) answer.add(List.of(u,v));
                oldest_reachable_ancestor[u] = Math.min(oldest_reachable_ancestor[u],oldest_reachable_ancestor[v]);
            }
            else oldest_reachable_ancestor[u] = Math.min(oldest_reachable_ancestor[u], entry_time[v]);
        }
    }
}
