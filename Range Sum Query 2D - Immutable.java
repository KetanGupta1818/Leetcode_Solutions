class NumMatrix {
    int[][] matirx;
    int[][] sum;
    public NumMatrix(int[][] matrix) {
        this.sum = new int[matrix.length+1][matrix[0].length+1];
       int m = matrix.length;
        int n = matrix[0].length;
        for(int r=1;r<=m;r++){
            for(int c=1;c<=n;c++){
                sum[r][c] = matrix[r-1][c-1] + sum[r][c-1] + sum[r-1][c] -sum[r-1][c-1];
            }
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2+1][col2+1] - sum[row1][col2+1] - sum[row2+1][col1] + sum[row1][col1];
    }
}
