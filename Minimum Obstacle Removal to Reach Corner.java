class Solution {
    int m,n;
    int[] dir = {0,1,0,-1,0};
    public int minimumObstacles(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<m*n;i++) graph.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int d=0;d<4;d++){
                    int next_x = i + dir[d];
                    int next_y = j + dir[d+1];
                    if(isValidPoint(next_x,next_y)){
                        graph.get(next_x*n+next_y).add(new int[]{i*n+j,grid[i][j]});
                        graph.get(i*n+j).add(new int[]{next_x*n+next_y,grid[next_x][next_y]});
                    }
                }
            }
        }
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[]{0,grid[0][0]});
        int[] shortestDistance = new int[m*n];
        Arrays.fill(shortestDistance,Integer.MAX_VALUE);
        shortestDistance[0] = grid[0][0];
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int source = cur[0];
            for(int[] next: graph.get(source)){
                int next_vertex = next[0];
                int next_vertex_weight = next[1];
                if(shortestDistance[next_vertex]>shortestDistance[source]+next_vertex_weight){
                    shortestDistance[next_vertex] = shortestDistance[source]+next_vertex_weight;
                     if(next_vertex == m*n-1) return shortestDistance[next_vertex];
                    queue.offer(new int[]{next_vertex,shortestDistance[next_vertex]});
                }
            }
        }
        return -101;
    }
    private boolean isValidPoint(int i, int j){
        return i>=0 && j>=0 && i<m && j<n;
    }
}
