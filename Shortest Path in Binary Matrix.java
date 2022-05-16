class Solution {
    private int[] dir = {-1,0,-1,-1,1,0,1,1,-1};
    private int n;
    public int shortestPathBinaryMatrix(int[][] grid) {
        this.n = grid.length;
        Queue<int[]> queue = new ArrayDeque<>();
        if(grid[0][0] == 0) queue.offer(new int[]{0,0});
        grid[0][0] = 1;
        int steps = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] cur_point = queue.poll();
                int x = cur_point[0];
                int y = cur_point[1];
                if(x == n-1 && y == n-1) return steps;
                for(int d=0;d<dir.length-1;d++){
                    int next_x = dir[d] + x;
                    int next_y = dir[d+1] + y;
                    if(isPointValid(next_x,next_y) && grid[next_x][next_y]==0){
                        queue.offer(new int[]{next_x,next_y});
                        grid[next_x][next_y] = 1;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    private boolean isPointValid(int i, int j){
        return i<n && j<n && i>=0 && j>=0;
    }
}
