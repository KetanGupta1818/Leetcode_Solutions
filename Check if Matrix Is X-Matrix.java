class Solution {
    public boolean checkXMatrix(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            if(grid[i][i]==0) return false;
            grid[i][i] = 0;
        }
        for(int i=0;i<grid.length;i++){
            if(grid.length%2==1 && i==grid.length/2) continue;
            if(grid[grid.length-1-i][i]==0) return false;
            grid[grid.length-1-i][i] = 0;
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j< grid.length;j++){
                if(grid[i][j]!=0) return false;
            }
        }
        return true;
    }
}
