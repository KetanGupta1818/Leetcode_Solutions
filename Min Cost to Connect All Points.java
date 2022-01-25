public class Solution{
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        UnionFind uf = new UnionFind(n);
        Queue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        for(int i=0;i<n-1;i++){
            for(int j=1;j<n;j++){
                minHeap.offer(new Edge(i,j,Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1])));
            }
        }
        int edgesAdded = 0;
        int answer= 0;
        while(edgesAdded!=n-1){
            Edge currentEdge = minHeap.poll();
            if(uf.isConnected(currentEdge.start,currentEdge.end)) continue;
            edgesAdded++;
            answer+=currentEdge.cost;
            uf.union(currentEdge.start,currentEdge.end);
        }
        return answer;
    }
}
class Edge{
    int start;
    int end;
    int cost;

    public Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}
class UnionFind{
    int[] rank;
    int[] root;
    public UnionFind(int size){
        this.rank = new int[size];
        this.root = new int[size];
        for(int i=0;i<size;i++){
            rank[i] = 1;
            root[i] = i;
        }
    }
    public int find(int x){
        if(x==root[x]) return x;
        return root[x] = find(root[x]);
    }
    public boolean isConnected(int x, int y){
        return find(x)==find(y);
    }
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX!=rootY){
            if(rank[rootX]>rank[rootY]) root[rootY] = rootX;
            else if(rank[rootY]>rank[rootX]) root[rootX] = rootY;
            else{
                root[rootX] = rootY;
                rank[rootY]++;
            }
        }
    }
}
