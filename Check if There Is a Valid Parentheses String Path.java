class Solution {
   ArrayList<ArrayList<HashSet<Integer>>> matrix;
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        matrix = new ArrayList<>();
        for(int i=0;i<m;i++){
            matrix.add(new ArrayList<>());
        }
         for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){
                 matrix.get(i).add(new HashSet<>());
             }
         }
        if(grid[0][0] == ')') return false;
        matrix.get(0).get(0).add(1);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                updateMatrix(grid,i,j);
        }
        return matrix.get(m-1).get(n-1).contains(0);
    }
    private void updateMatrix(char[][] grid, int i, int j){

        int bracket = grid[i][j] == '(' ? 1: -1;
        if(i>0){
            if(bracket == 1){
                for(int val: matrix.get(i-1).get(j))
                    matrix.get(i).get(j).add(val+1);
            }
            else{
                for(int val: matrix.get(i-1).get(j)){
                    if(val>0)
                        matrix.get(i).get(j).add(val-1);
                }
            }
        }
        if(j>0){
            if(bracket == 1){
                for(int val: matrix.get(i).get(j-1))
                    matrix.get(i).get(j).add(val+1);
            }
            else{
                for(int val: matrix.get(i).get(j-1)){
                    if(val>0)
                        matrix.get(i).get(j).add(val-1);
                }
            }
        }
    }
}
