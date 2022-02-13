class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int rep = 0;
        while(answer.size()<m*n){
            boundaryAdder(matrix,answer,rep,m-rep-1,rep,n-rep-1);
            rep++;
        }
        return answer;
    }
    public void boundaryAdder(int[][] matrix,List<Integer> answer,int row1,int row2,int col1,int col2){
        for(int i=col1;i<=col2;i++) answer.add(matrix[row1][i]);
        if(row1==row2) return;
        for(int i=row1+1;i<=row2;i++) answer.add(matrix[i][col2]);
        if(col1==col2) return;
        for(int i=col2-1;i>=col1;i--) answer.add(matrix[row2][i]);
        for(int i=row2-1;i>row1;i--) answer.add(matrix[i][col1]);
    }
}
