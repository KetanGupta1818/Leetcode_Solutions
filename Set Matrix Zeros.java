class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] zeroVisited = new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j] == 0 && !zeroVisited[i][j]){
                    for(int r=0;r<rows;r++){
                        if(matrix[r][j]==0 && !zeroVisited[r][j]) continue;
                        matrix[r][j] = 0;
                        zeroVisited[r][j] = true;
                    }
                    for(int c=0;c<cols;c++){
                        if(matrix[i][c]==0 && !zeroVisited[i][c]) continue;
                        matrix[i][c] = 0;
                        zeroVisited[i][c] = true;
                    }
                }
            }
        }
    }
}
