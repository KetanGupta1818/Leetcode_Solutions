class Solution {
    int m,n;
    int[] dir = new int[]{0,1,0,-1,0};
    public int longestIncreasingPath(int[][] matrix) {
        this.m=matrix.length;
        this.n=matrix[0].length;
        int max=0;
        boolean[][] visited = new boolean[m][n];
        int[][] value = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max = Math.max(max,dfs(i,j,value,visited,matrix));
            }
        }
        return max+1;
    }
    private int dfs(int r, int c, int[][] value, boolean[][] visited, int [][] matrix){
        if(visited[r][c]) return value[r][c];
        visited[r][c] = true;
        int max=0;
        for(int d=0;d<4;d++){
            int next_r =r+ dir[d];
            int next_c =c+ dir[d+1];
            if(isValid(next_r,next_c) && matrix[r][c]<matrix[next_r][next_c]){
                max = Math.max(max,dfs(next_r,next_c,value,visited,matrix)+1);
            }
        }
        return value[r][c] = max;
    }
    private boolean isValid(int r, int c){
        return r>=0 && r<m && c>=0 && c<n;
    }
}
