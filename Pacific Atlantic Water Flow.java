class Solution {
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    int m,n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.m = heights.length;
        this.n = heights[0].length;
        boolean[] pacific = new boolean[m*n];
        boolean[] atlantic = new boolean[m*n];
        Queue<Integer> pacificQueue = new ArrayDeque<>();
        Queue<Integer> atlanticQueue = new ArrayDeque<>();
        for(int i=0;i<m;i++) {
            pacificQueue.offer(i*n);
            atlanticQueue.offer(i*n+n-1);
            pacific[i*n] = true;
            atlantic[i*n+n-1] = true;
        }
        for(int j=0;j<n;j++){
            pacificQueue.offer(j);
            atlanticQueue.offer((m-1)*n+j);
            pacific[j] = true;
            atlantic[(m-1)*n+j] = true;
        }
        bfs(heights,pacific,pacificQueue);
        bfs(heights,atlantic,atlanticQueue);
        List<List<Integer>> answer = new ArrayList<>();
        for(int i=0;i<m*n;i++) if(atlantic[i] && pacific[i]) answer.add(List.of(i/n,i%n));
        return answer;
    }
    private void bfs(int[][] heights, boolean[] visited, Queue<Integer> queue){
        while(!queue.isEmpty()) {
            int curPoint = queue.poll();
            int x = curPoint / n;
            int y = curPoint % n;
            int height = heights[x][y];
            for (int[] d : dir) {
                int next_x = x + d[0];
                int next_y = y + d[1];
                if (isValid(next_x, next_y) && heights[next_x][next_y] >= height && !visited[next_x * n + next_y]) {
                    queue.offer(next_x * n + next_y);
                    visited[next_x * n + next_y] = true;
                }
            }
        }
    }
    private boolean isValid(int i, int j){
        return i>=0 && j>=0 && i<m && j<n;
    }
}
