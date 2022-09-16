class Solution {
    int[] height;
    double[] prob;
    boolean[] isLeaf;
    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<List<Integer>> tree = new ArrayList<>();
        this.height = new int[n];
        this.prob = new double[n];
        this.isLeaf = new boolean[n];
        for(int i=0;i<n;i++) tree.add(new ArrayList<>());
        for(int[] edge: edges){
            tree.get(edge[0]-1).add(edge[1]-1);
            tree.get(edge[1]-1).add(edge[0]-1);
        }
        dfs(tree,1D,0,-1,0);
        target--;
        if(t == height[target]) return prob[target];
        if(isLeaf[target] && t>height[target]) return prob[target];
        return 0D;
    }
    private void dfs(List<List<Integer>> tree, double p, int node, int parent, int h){
        prob[node] = p;
        height[node] = h;
        double children = (double)tree.get(node).size()-1;
        if(parent==-1) children++; 
        if(children==0) isLeaf[node] = true;
        for(int child: tree.get(node)){
            if(child == parent) continue;
            dfs(tree,p*(1D/children),child,node,h+1);
        }
    }
}
