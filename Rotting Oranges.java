class Solution {
        public int orangesRotting(int[][] grid) {
        if(grid.length==0) return 0;
        Queue<int[]> queue = new ArrayDeque<>();
        int rows = grid.length;
        int columns = grid[0].length;
        int freshOranges = 0;
        int minutes = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2) queue.offer(new int[]{i,j});
                if(grid[i][j]==1) freshOranges++;
            }
        }
        if(freshOranges==0) return 0;
        while(!queue.isEmpty()){
            ++minutes;
            int size = queue.size();
            int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
            for(int s=0;s<size;s++){
                int[] cur = queue.poll();
                for(int[] direction: directions){
                    int x = cur[0] + direction[0];
                    int y = cur[1] + direction[1];
                    if(x<0||y<0||x>=rows||y>=columns||grid[x][y]==2||grid[x][y]==0) continue;
                    grid[x][y] = 2;
                    freshOranges--;
                    queue.offer(new int[]{x,y});
                }
            }
        }
        return freshOranges<=0?--minutes:-1;
    }
}
