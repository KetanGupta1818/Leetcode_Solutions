class Solution {
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    public int closedIsland(int[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++) if(grid[i][j] == 0 && !dfs(grid,i,j)) count++;
        }
        return count++;
    }
    private boolean dfs(int[][] grid, int row, int col){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col] == 1) return false;
        grid[row][col] = 1;
        boolean res = false;
        for(int[] d: dir){
            int x = row + d[0];
            int y = col + d[1];
            res = dfs(grid,x,y) || res;
        }
        return res || row==0 || col==0 || row==grid.length-1 || col==grid[0].length-1;
    }
}
