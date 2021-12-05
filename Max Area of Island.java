class Solution {
    static int[][] grid;
    static boolean[][] seen;
    public int maxAreaOfIsland(int[][] grid) {
        seen = new boolean[grid.length][grid[0].length];
        this.grid = grid;
        int maxi = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(seen[i][j]) continue;
                if(grid[i][j]==1){
                    maxi = Math.max(maxi,dfsArea(i,j));
                }
                seen[i][j] = true;
            }
        }
        return maxi;
    }
    public static int dfsArea(int i, int j){
        int area = 0;
        if(seen[i][j]) return area;
        seen[i][j] = true;
        if(i>0 && grid[i-1][j] == 1) area = area + dfsArea(i-1,j);
        if(j>0 && grid[i][j-1] == 1) area = area + dfsArea(i,j-1);
        if(i<grid.length-1 && grid[i+1][j] == 1) area = area + dfsArea(i+1,j);
        if(j<grid[0].length-1 && grid[i][j+1] == 1) area = area + dfsArea(i,j+1);
        return area+1;
    }
}
