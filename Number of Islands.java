public class Solution {
    private int n;
    private int m;
    private boolean[][] visited;
    private UnionFind uf;
    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        System.out.println("Final Answer: " + new Solution().numIslands(grid));
    }
    public int numIslands(char[][] grid) {
        this.n = grid[0].length;
        m = grid.length;
        this.visited = new boolean[m][n];
        uf = new UnionFind(grid);
        for(int row = 0; row< m; row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]=='0' || visited[row][col]) continue;
                dfs(grid,row,col);
            }
        }
        return uf.numberOfRoots();
    }
    public void dfs(char[][] grid, int row, int col){
        visited[row][col] = true;
        if(col<n-1 && grid[row][col+1]=='1' && !visited[row][col+1]){
            uf.union(n*row+col+1,n*row+col+2);
            dfs(grid,row,col+1);
        }
        if(row<m-1 && grid[row+1][col]=='1' && !visited[row+1][col]){
            uf.union(n*row+col+1,n*(row+1)+col+1);
            dfs(grid,row+1,col);
        }
        if(col>0 && grid[row][col-1]=='1' && !visited[row][col-1]){
            uf.union(n*row+col+1,n*row+col);
            dfs(grid,row,col-1);
        }
        if(row>0 && grid[row-1][col]=='1' && !visited[row-1][col]){
            uf.union(n*row+col+1,n*(row-1)+col+1);
            dfs(grid,row-1,col);
        }
    }
}
class UnionFind{
    private int[] root;
    private int[] rank;

    public UnionFind(char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        this.root = new int[m * n +1];
        this.rank = new int[m * n +1];
        int index = 0;
        root[index++] = -1;
        for (char[] chars : grid) {
            for (int j = 0; j < n; j++) {
                if (chars[j] == '1') root[index] = index;
                else root[index] = -1;
                rank[index++] = 1;
            }
        }
    }
    public int find(int cur){
        if(cur == root[cur]) return cur;
        return root[cur] = find(root[cur]);
    }
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX!=rootY){
            if(rank[rootX]>rank[rootY]){
                root[rootY] = rootX;
            }
            else if(rank[rootY]>rank[rootX]){
                root[rootX] = rootY;
            }
            else{
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
    public void display(){
        System.out.println("Roots: " + Arrays.toString(root));
        System.out.println("Rank: " + Arrays.toString(rank));
    }
    public int numberOfRoots(){
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<root.length;i++){
            if(root[i]==-1) continue;
            set.add(find(root[i]));
        }
        return set.size();
    }
}
