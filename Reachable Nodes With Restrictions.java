class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        boolean[] allowed = new boolean[n];
        List<List<Integer>> tree = new ArrayList<>();
        for(int i=0;i<n;i++){
            allowed[i] = true;
            tree.add(new ArrayList<>());
        }
        for(int res: restricted) allowed[res] = false;
        for(int[] e: edges){
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        return dfs(tree,new boolean[n],allowed,0);
    }
    private int dfs(List<List<Integer>> tree, boolean[] visited, boolean[] allowed,int node){
        visited[node] = true;
        int count = 1;
        for(int child: tree.get(node)){
            if(visited[child] || !allowed[child]) continue;
            count += dfs(tree,visited,allowed,child);
        }
        return count;
    }
}
