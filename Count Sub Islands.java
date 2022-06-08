class Solution {
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int coutner = 0;
        for(int i=0;i<grid1.length;i++){
            for(int j=0;j<grid2[0].length;j++){
                if(grid2[i][j]==1 && dfs(grid1,grid2,i,j)) coutner++;
            }
        }
        return coutner;
    }
    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j){
        if(grid1[i][j] != grid2[i][j]) return false;
        grid2[i][j] = 0;
        boolean res = true;
        for(int[] d: dir){
            int x = i + d[0];
            int y = j + d[1];
            if(x>=0 && y>=0 && x<grid1.length && y<grid1[0].length && grid2[x][y]==1)
                res = dfs(grid1,grid2,x,y) && res;
        }
        return res;
    }
}
