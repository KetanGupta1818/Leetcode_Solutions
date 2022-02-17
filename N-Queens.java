class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] chars = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chars[i][j] = '.';
            }
        }
        solve(res,chars,0);
        return res;
    }
    public void solve(List<List<String>> res, char[][] chars, int row){
        if(row==chars.length){
            res.add(convert(chars));
            return;
        }
        for(int i=0;i<chars.length;i++){
            if(valid(chars,row,i)){
                chars[row][i] = 'Q';
                solve(res,chars,row+1);
                chars[row][i] = '.';
            }
        }
    }
    private boolean valid(char[][] chars, int row, int col){
        for(int i=row-1;i>=0;i--){
            if(chars[i][col]=='Q') return false;
        }
        for(int i=row-1,j=col+1;i>=0&&j<chars.length;i--,j++){
            if(chars[i][j]=='Q') return false;
        }
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(chars[i][j]=='Q') return false;
        }
        return true;
    }
    private List<String> convert(char[][] chess) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            path.add(new String(chess[i]));
        }
        return path;
    }
}
