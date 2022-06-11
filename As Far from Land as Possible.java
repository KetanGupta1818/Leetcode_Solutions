class Solution {
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    int n;
    public int maxDistance(int[][] grid) {
        int sum=0,moves=0;
        this.n=grid[0].length;
        for(int[] g: grid) for(int val: g) sum+=val;
        if(sum==n*n || sum==0) return -1;
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1) queue.offer(new int[]{i,j});
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];
                for(int[] d: dir){
                    int next_x = x + d[0];
                    int next_y = y + d[1];
                    if(isValid(next_x,next_y) && grid[next_x][next_y]==0){
                        grid[next_x][next_y] = 1;
                        queue.offer(new int[]{next_x,next_y});
                    }
                }
            }
            moves++;
        }
        return moves-1;
    }
    private boolean isValid(int i, int j) {
        return i>=0 && j>=0 && i<n && j<n;
    }
}
