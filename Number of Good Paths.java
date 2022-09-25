class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        TreeMap<Integer,List<Edge>> map = new TreeMap<>();
        int n = vals.length;
        Map<Integer,List<Integer>> valueToNodes = new HashMap<>();
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int maxValue = Math.max(vals[u],vals[v]);
            List<Edge> list = map.getOrDefault(maxValue,new ArrayList<>());
            list.add(new Edge(u,v));
            map.put(maxValue,list);
        }
        for(int i=0;i<n;i++) {
            List<Integer> l1 = valueToNodes.getOrDefault(vals[i],new ArrayList<>());
            l1.add(i);
            valueToNodes.put(vals[i],l1);
        }
        UnionFind uf = new UnionFind(n);
        int answer = n;
        for(int val: map.keySet()){
            List<Edge> edgeList = map.get(val);
            for(Edge edge: edgeList) uf.union(edge.u,edge.v);
            Map<Integer,Integer> freq = new HashMap<>();
            List<Integer> index = valueToNodes.get(val);
            for(int i: index) freq.put(uf.find(i),freq.getOrDefault(uf.find(i),0)+1);
            for(int key: freq.keySet()) {
                int cnt = freq.get(key);
                answer += cnt*(cnt-1)/2;
            }
        }
        return answer;
    }

}
class UnionFind{
    int[] rank;
    int[] root;
    
    public UnionFind(int n){
        this.root = new int[n];
        this.rank = new int[n];
        for(int i=0;i<n;i++){
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int v){
        if(v == root[v]) return v;
        return root[v] = find(root[v]);
    }

    public boolean isConnected(int x, int y){
        return find(x) == find(y);
    }

    public boolean union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY) return false;
        if(rank[rootX] > rank[rootY]) root[rootY] = rootX;
        else if(rank[rootY] > rank[rootX]) root[rootX] = rootY;
        else{
            rank[rootX]++;
            root[rootY] = rootX;
        }
        return true;
    }
    public boolean onlyOneRoot(){
        int root1 = find(0);
        for(int i=1;i<root.length;i++) if(root1!=find(i)) return false;
        return true;
    }
}
class Edge{
    int u;
    int v;

    public Edge(int u, int v) {
        this.u = u;
        this.v = v;
    }
}
