class Solution {
    
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[row][col] = true;
        queue.offer(new int[]{row,col});
        int oldColor = grid[row][col];
        List<int[]> list = new ArrayList<>();
        while(!queue.isEmpty()){
            int[] cur_pos = queue.poll();
            int x = cur_pos[0];
            int y = cur_pos[1];
            if(x==0 || y==0 || x==grid.length-1 || y==grid[0].length-1) list.add(new int[]{x,y});
            for(int[] d: dir){
                int next_x = x + d[0];
                int next_y = y + d[1];
                if(next_x>=0 && next_y>=0 && next_x<grid.length && next_y<grid[0].length){
                    if(grid[next_x][next_y] == oldColor){
                        if(!visited[next_x][next_y]){
                            visited[next_x][next_y] = true;
                            queue.offer(new int[]{next_x,next_y});
                        }
                    }
                    else list.add(new int[]{x,y});
                }
            }
        }
        for(int[] p: list) grid[p[0]][p[1]] = color;
        return grid;
    }
}
