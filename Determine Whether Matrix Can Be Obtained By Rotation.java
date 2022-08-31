class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        boolean r1=true,r2=true,r3=true,r4=true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]!=target[i][j]) r1=false;
                if(mat[i][j]!=target[j][n-i-1]) r2=false;
                if(mat[i][j]!=target[n-i-1][n-j-1]) r3=false;
                if(mat[i][j]!=target[n-j-1][i]) r4=false;
            }
        }
        return r1||r2||r3||r4;
    }
}
