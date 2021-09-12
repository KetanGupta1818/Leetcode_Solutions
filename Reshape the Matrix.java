class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if(m*n != r*c) return mat;
        int[] arr = new int[r*c];
        int[][] mat2 = new int[r][c];
        int k =0 ;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[k] = mat[i][j];
                k++;
            }
        }
        k=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                mat2[i][j] = arr[k];
                k++;
            }
        }
        return mat2;
    }
}
