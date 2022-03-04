class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] mat = new double[102][102];
        mat[0][0] = (double) poured;
        for(int r=0;r<=query_row;r++){
            for(int c=0;c<=r;c++){
                double q = (mat[r][c]-1.0)/2.0;
                if(q>0){
                    mat[r+1][c]+=q;
                    mat[r+1][c+1]+=q;
                }
            }
        }
        return Math.min(1.0,mat[query_row][query_glass]);
    }
}
