class Solution {
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    public int numEnclaves(int[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 1){
                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    visited[i][j] = true;
                    int coutner = sizeOfLand(grid,visited,i,j);
                    if(!dfs(grid,i,j)) count+=coutner;
                }
            }
        }
        return count;
    }
    private boolean dfs(int[][] grid, int row, int col){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col] == 0) return false;
        grid[row][col] = 0;
        boolean res = false;
        for(int[] d: dir){
            int x = row + d[0];
            int y = col + d[1];
            res = dfs(grid,x,y) || res;
        }
        return res || row==0 || col==0 || row==grid.length-1 || col==grid[0].length-1;
    
    }
    private int sizeOfLand(int[][] grid, boolean[][] visited, int row, int col){
        int sum = 1;
        for(int[] d: dir){
            int x = row + d[0];
            int y = col + d[1];
            if(x>0 && y>0 && x<grid.length && y<grid[0].length && grid[x][y]==1 && !visited[x][y]){
                visited[x][y] = true;
                sum+=sizeOfLand(grid,visited,x,y);
            }
        }
        return sum;
    }
}
