class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] dir = {{-1,0},
                     {-1,1},
                     {0,1},
                     {1,1},
                     {1,0},
                     {1,-1},
                     {0,-1},
                     {-1,-1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int ones = 0;
                for(int[] d: dir){
                    if(check(m,n,i+d[0],j+d[1]) && (board[i+d[0]][j+d[1]]&1)==1)
                        ones++;
                }
                if(board[i][j]==1){
                    if(ones==2 || ones==3) board[i][j]+=2;
                }
                else 
                    if(ones==3) board[i][j]+=2;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j]>>=1;
            }
        }
    }
    public boolean check(int m, int n ,int i, int j){
        if(i<0 || j<0 || i>=m || j>=n) return false;
        return true;
    }
}
