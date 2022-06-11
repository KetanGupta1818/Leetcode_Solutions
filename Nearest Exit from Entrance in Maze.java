class Solution {
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    int m,n;
    public int nearestExit(char[][] maze, int[] entrance) {
        this.m = maze.length;
        this.n = maze[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{entrance[0],entrance[1]});
        maze[entrance[0]][entrance[1]] = '+';
        int moves = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int s=0;s<size;s++){
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];
                if(moves!=0) if(x==0 || y==0 || x==m-1 || y==n-1) return moves;
                for(int[] d: dir){
                    int next_x = x + d[0];
                    int next_y = y + d[1];
                    if(isValid(next_x,next_y) && maze[next_x][next_y] == '.'){
                        queue.offer(new int[]{next_x,next_y});
                        maze[next_x][next_y] = '+';
                    }
                }
            }
            moves++;
        }
        return -1;
    }
    private boolean isValid(int i,int j){
        return i>=0 && j>=0 && i<m && j<n;
    }
}
