class Solution {
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    int m,n;
    public int shortestBridge(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 2;
                    queue.offer(new int[]{i,j});
                    dfs(i,j,queue,grid);
                    System.out.println(queue.peek()[0]);
                    return bfs(queue,grid);
                }
            }
        }
        return -1;
    }
    private boolean isValid(int row, int col){
        return row>=0 && col>=0 && row<m && col<n;
    }
    private void dfs(int i, int j, Queue<int[]> queue, int[][] grid){
        for(int[] d: dir){
            int next_x = i + d[0];
            int next_y = j + d[1];
            if(isValid(next_x,next_y) && grid[next_x][next_y] == 1){
                grid[next_x][next_y] = 2;
                queue.offer(new int[]{next_x,next_y});
                dfs(next_x,next_y,queue,grid);
            }
        }
    }
    private int bfs(Queue<int[]> queue, int[][] grid){
        int moves = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int s=0;s<size;s++){
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];
                
                for(int[] d: dir){
                    int next_x = x + d[0];
                    int next_y = y + d[1];
                    
                    if(isValid(next_x,next_y) ){
                        if(grid[next_x][next_y] == 1) return moves;
                        if(grid[next_x][next_y] == 0){
                        grid[next_x][next_y] = 2;
                        queue.offer(new int[]{next_x,next_y});}
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}
