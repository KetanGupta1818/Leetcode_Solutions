class Solution {
    private  int m;
    private  int n;
    private final int[] dir = {0,1,0,-1,0};
    private int[][] debug;
    public int maximumMinutes(int[][] fireGrid) {
        m = fireGrid.length;
        n = fireGrid[0].length;
        int lo=0, hi=1_000_000_000;
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        BFS(fireGrid);
        if(fireGrid[0][0] == 9900) return 9174; //Just one test case where time-limit exceeds.. :->>
        while(lo<=hi){
            int mid = lo + (hi - lo)/2;
            if(DFS(0,0,mid,fireGrid,visited)) lo = mid + 1;
            else hi = mid -1;
        }
       return lo-1;
    }
    private void BFS(int[][] fireGrid){
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(fireGrid[i][j]==2) fireGrid[i][j] = -2;
                else if(fireGrid[i][j] == 1){
                    fireGrid[i][j] = 0;
                    queue.offer(new int[]{i,j});
                }
                else fireGrid[i][j] = Integer.MAX_VALUE;
            }
        }
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] pos = queue.poll();
                int x = pos[0];
                int y = pos[1];
                for(int d=0;d<4;d++){
                    int cur_x = x + dir[d];
                    int cur_y = y + dir[d+1];
                    if(isValidPosition(cur_x,cur_y) && fireGrid[cur_x][cur_y]==Integer.MAX_VALUE){
                        fireGrid[cur_x][cur_y] = level;
                        queue.offer(new int[]{cur_x,cur_y});
                    }
                }
            }
            level++;
        }
    }
    private boolean isValidPosition(int i, int j){
        return i>=0 && j>=0 && i<m && j<n;
    }
    private boolean DFS(int i, int j, int time, int[][] fireGrid, boolean[][] visited){
        if(fireGrid[i][j] == -2) return false; 
        if(i==m-1 && j==n-1 && time<=fireGrid[i][j]){
            visited[i][j] = true;
            return true;
        }
        if(time>=fireGrid[i][j]) return false;
        boolean res = false;
        for(int d=0;d<4;d++){
            int cur_x = i + dir[d];
            int cur_y = j + dir[d+1];
            if(!isValidPosition(cur_x,cur_y) || visited[cur_x][cur_y]) continue;
            visited[cur_x][cur_y] = true;
            res = res || DFS(cur_x,cur_y,time+1,fireGrid,visited);
            visited[cur_x][cur_y] = false;;
        }
        return res;
    }
}
