class Solution {
    boolean[] visited;
    public int largestIsland(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        visited = new boolean[m*n];
        Union un = new Union(m*n);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dfs(grid,i,j,m,n,un);
            }
        }
        Map<Integer,Integer> rootToSizeMap = un.getMap();
        if(rootToSizeMap.size()==1){
            for(int k: rootToSizeMap.keySet())
                if(rootToSizeMap.get(k)==m*n) return m*n;
        }
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) continue;
                int cur_res = 0;
                Set<Integer> setOfRoots = new HashSet<>();
                if(i>0 && grid[i-1][j] == 1) setOfRoots.add(un.find((i-1)*n+j));
                if(i<m-1 && grid[i+1][j] == 1) setOfRoots.add(un.find((i+1)*n+j));
                if(j<n-1 && grid[i][j+1] == 1) setOfRoots.add(un.find(i*n+j+1));
                if(j>0 && grid[i][j-1] == 1) setOfRoots.add(un.find(i*n+j-1));
                for(int root: setOfRoots) {
                    cur_res+=rootToSizeMap.get(root);
                }
                res = Math.max(res,cur_res+1);
            }
        }
        return res;
    }
    private void dfs(int[][] grid, int r, int c, int m, int n, Union un){
        visited[r*n+c] = true;
        if(grid[r][c] == 0) return;
        if(r>0 && !visited[(r-1)*n+c] && grid[r-1][c]==1) {
            un.union(r*n+c,(r-1)*n+c);
            dfs(grid,r-1,c,m,n,un);
        }
        if(c>0 && !visited[r*n+c-1] && grid[r][c-1]==1) {
            un.union(r*n+c,r*n+c-1);
            dfs(grid,r,c-1,m,n,un);
        }
        if(r<m-1 && !visited[(r+1)*n+c] && grid[r+1][c]==1) {
            un.union(r*n+c,(r+1)*n+c);
            dfs(grid,r+1,c,m,n,un);
        }
        if(c<n-1 && !visited[r*n+c+1] && grid[r][c+1]==1) {
            un.union(r*n+c,r*n+c+1);
            dfs(grid,r,c+1,m,n,un);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Answer: " + sol.largestIsland(new int[][]{{1,0},{0,1}}));
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
        if(v == root[v]) return v;
        return root[v] = find(root[v]);
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
    public Map<Integer,Integer> getMap(){
        Map<Integer,Integer> rootToSizeMap = new HashMap<>();
        for(int i=0;i<root.length;i++)
            rootToSizeMap.put(find(i),rootToSizeMap.getOrDefault(find(i),0)+1);
        return rootToSizeMap;
    }
}
