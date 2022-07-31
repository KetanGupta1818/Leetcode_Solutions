class Solution {
    List<Integer> cycles = new ArrayList<>();
    int numberOfCycles = 0;
    public int longestCycle(int[] edges) {
        int[] visited = new int[edges.length];
        for(int i=0;i<edges.length;i++){
            if(edges[i]==-1 || visited[i]!=0) continue;
            dfs(edges,i,visited);
        }
        int max = -1;
        for(int v: cycles) max = Math.max(v,max);
        return max;
    }
    private void dfs(int[] a, int curNode,int[] visited){
        visited[curNode] = 2;
        if(a[curNode] == -1 || visited[a[curNode]]==1){ //No out edge 
            visited[curNode] = 1;
            return;
        }
        if(visited[a[curNode]] == 0){
            dfs(a,a[curNode],visited);
        }
        else{
            numberOfCycles++;
            cycles.add(0);
            dfs2(a,a[curNode],visited);
        }
        visited[curNode] = 1;
    }
    private  void dfs2(int[] a, int curNode, int[] visited){
        cycles.set(numberOfCycles-1,cycles.get(numberOfCycles-1)+1);
        visited[curNode] = 3;
        if(visited[a[curNode]] == 3) return;
        dfs2(a,a[curNode],visited);
    }
}
