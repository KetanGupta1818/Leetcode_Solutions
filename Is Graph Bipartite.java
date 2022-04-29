class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(color[i]==0 && !isValid(graph,1,color,i)) return false;
        }
        return true;
    }
    public boolean isValid(int[][] graph, int c, int[] color, int node){
        if(color[node] != 0) 
            return color[node] == c;
        color[node] = c;
        boolean res = true;
        for(int next: graph[node])
            res = res && isValid(graph,-c,color,next);
        return res;
    }
}
