class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Queue<Node> minHeapQueries = new PriorityQueue<>(Comparator.comparingInt(a -> a.edgeWeight));
        for(int i=0;i<queries.length;i++){
            minHeapQueries.offer(new Node(queries[i][2],i,queries[i][0],queries[i][1]));
        }
        Queue<Node> minHeapGraph = new PriorityQueue<>(Comparator.comparingInt(a -> a.edgeWeight));
        for(int[] edge: edgeList) minHeapGraph.offer(new Node(edge[2],-1,edge[0],edge[1]));
        boolean[] answer = new boolean[queries.length];
        UnionFind unionFind = new UnionFind(n);
        while(!minHeapQueries.isEmpty()){
            Node query = minHeapQueries.remove();
            while(!minHeapGraph.isEmpty() && query.edgeWeight>minHeapGraph.peek().edgeWeight){
                Node edge = minHeapGraph.remove();
                unionFind.union(edge.u,edge.v);
            }
            answer[query.index] = unionFind.isConnected(query.u, query.v);
        }
        return answer;
    }
}
class Node{
    int edgeWeight;
    int index;
    int u;
    int v;

    public Node(int edgeWeight, int index, int u, int v) {
        this.edgeWeight = edgeWeight;
        this.index = index;
        this.u = u;
        this.v = v;
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
