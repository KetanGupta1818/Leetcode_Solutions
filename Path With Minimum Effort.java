class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length,n=heights[0].length,cur_max=0;
        Queue<int[]> queue = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        Union un = new Union(m*n);
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                if(r!=m-1)
                    queue.offer(new int[]{r*n+c,(r+1)*n+c,Math.abs(heights[r][c]-heights[r+1][c])});
                if(c!=n-1)
                    queue.offer(new int[]{r*n+c,r*n+c+1,Math.abs(heights[r][c]-heights[r][c+1])});
            }
        }
        while(!un.isConnected(0,m*n-1)){
            int[] arr = queue.poll();
            if(!un.isConnected(arr[0],arr[1])){
                un.union(arr[0],arr[1]);
                cur_max = Math.max(arr[2],cur_max);
            }
        }
        return cur_max;
    }
}
class Union{
    int[] rank;
    int[] root;
    
    public Union(int n){
        this.root = new int[n];
        this.rank = new int[n];
        for(int i=0;i<n;i++){
            root[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int v){
        if(v==root[v]) return v;
        return root[v] = find(root[v]);
    }
    
    public boolean isConnected(int x, int y){
        return find(x) == find(y);
    }
    
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY) return;
        if(rank[rootX]>rank[rootY]) root[rootY] = rootX;
        else if(rank[rootX]<rank[rootY]) root[rootX] = rootY;
        else {
            root[rootX] = rootY;
            rank[rootY]++;
        }
    }
}
