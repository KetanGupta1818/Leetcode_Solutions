class Solution {
    int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++) sum+=grid[i][j];
        }
        int totalEdges = sum*4;
        int sb = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    for(int d=0;d<4;d++){
                        int x = i+dir[d][0];
                        int y = j+dir[d][1];
                        if(isValid(x,y,grid.length,grid[0].length) && grid[x][y] == 1) totalEdges--;
                    }
                }
            }
        }
        return totalEdges;
    }
    private boolean isValid(int i, int j, int rows, int cols){
        return i>=0 && j>=0 && i<rows && j<cols;
    }
}
