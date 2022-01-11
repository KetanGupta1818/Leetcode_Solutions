class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        int[] arrRow = new int[n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]>n) return false;
                arrRow[matrix[i][j]]++;
            }
            for(int j=0;j<n;j++){
                if(--arrRow[matrix[i][j]]!=0) return false;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]>n) return false;
                arrRow[matrix[j][i]]++;
            }
            for(int j=0;j<n;j++){
                if(--arrRow[matrix[j][i]]!=0) return false;
            }
        }
        return true;
    }
}
