class Solution {
    public int makeConnected(int n, int[][] connections) {
        int extra=0;
        Union un = new Union(n);
        for(int[] con: connections){
            if(un.isConnected(con[0],con[1])) extra++;
            else un.union(con[0],con[1]);
        }
        int numberOfRoots = un.numberOfRoots();
        return extra>=numberOfRoots-1?numberOfRoots-1:-1;
    }
}
class Union{
    int[] rank;
    int[] root;
    
    public Union(int n){
        this.rank = new int[n];
        this.root = new int[n];
        for(int i=0;i<n;i++){
            rank[i] = 1;
            root[i] = i;
        }
    }
    
    public boolean isConnected(int x, int y){
        return find(x) == find(y);
    }
    
    public int find(int v){
        if(v == root[v]) return v;
        return root[v] = find(root[v]);
    }
    
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        
        if(rank[rootY] > rank[rootX]) root[rootX] = rootY;
        else if(rank[rootY] < rank[rootX]) root[rootY] = rootX;
        else {
            root[rootY] = rootX;
            rank[rootX]++;
        }
    }
    
    public int numberOfRoots(){
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<rank.length;i++) set.add(find(i));
        return set.size();
    }
}
