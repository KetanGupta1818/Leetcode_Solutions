class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int answer = 0;
        int[][] ps = new int[rows+1][cols+1];
        for(int r=1;r<=rows;r++){
            for(int c=1;c<=cols;c++){
                ps[r][c] = ps[r-1][c] + ps[r][c-1] + matrix[r-1][c-1] - ps[r-1][c-1];
            }
        }
        int val = 0;
        for(int r1=1;r1<=rows;r1++){
        for(int c1=1;c1<=cols;c1++){
                for(int r2=r1;r2<=rows;r2++){
                    for(int c2=c1;c2<=cols;c2++){
                        if(ps[r2][c2]-ps[r1-1][c2]-ps[r2][c1-1]+ps[r1-1][c1-1] == target) answer++;
                    }
                }
            }
        }
        return answer;
    }
}
