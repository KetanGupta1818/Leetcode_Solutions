public class Solution {
    List<List<String>> answer = new ArrayList<>();
    int n;
    public int totalNQueens(int n) {
        this.n = n;
        char[][] queens = new char[n][n];
        for(int i=0;i<n;i++) Arrays.fill(queens[i],'.');
        rec(0,queens);
        return this.answer.size();
    }
    private void rec(int level, char[][] queens){
        if(level == n){
            List<String> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                String s = String.valueOf(queens[i]);
                list.add(s);
            }
            answer.add(list);
            return;
        }
        for(int i=0;i<n;i++){
            if(isPointValid(level,i,queens)){
                queens[level][i] = 'Q';
                rec(level+1,queens);
                queens[level][i] = '.';
            }
        }
    }
    private boolean isPointValid(int i, int j, char[][] queens){
        for(int x=i-1;x>=0;x--) if(queens[x][j] == 'Q') return false; 
        for(int y=j-1,x=i-1;x>=0&&y>=0;x--,y--) if(queens[x][y] == 'Q') return false;
        for(int y=j+1,x=i-1; x>=0&&y<n;x--,y++) if(queens[x][y] == 'Q') return false;
        return true;
    }
}
