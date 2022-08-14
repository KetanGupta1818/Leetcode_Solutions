class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] answer = new int[n-2][n-2];
        for(int r=0;r<n-2;r++){
            for(int c=0;c<n-2;c++){
                int max = grid[r][c];
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++) max = Math.max(max,grid[i+r][j+c]);
                }
                answer[r][c] = max;
            }
        }
        return answer;
    }
}
