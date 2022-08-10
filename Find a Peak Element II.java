class Solution {
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    public int[] findPeakGrid(int[][] mat) {
        for(int i=0;i<mat.length;i++){
            p: for(int j=0;j<mat[0].length;j++){
                for(int[] d: dir){
                    if(mat[i][j] < getPoint(mat,i+d[0],j+d[1])) continue p;
                }
                return new int[]{i,j};
            }
        }
        return new int[]{};
    }
    private int getPoint(int[][] mat, int i, int j){
        if(i<0 || i>mat.length-1 || j<0 || j>mat[0].length-1) return -1;
        return mat[i][j];
    }
}
