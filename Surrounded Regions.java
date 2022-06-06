class Solution {
    int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    int rows,cols;
    public void solve(char[][] board) {
        rows=board.length;
        cols=board[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j] == 'O') {
                    if(!isConnectedToBorderO(board,i,j,new boolean[rows][cols])) 
                        mutateBoard(board,i,j);
                }
            }
        }
    }
    private boolean isValid(int i, int j){
        return i>=0 && j>=0 && i<rows && j<cols;
    }
    private boolean isConnectedToBorderO(char[][] board, int i, int j,boolean[][] visited){
        visited[i][j] = true;
        if(i==0 || j==0 || i==rows-1 || j==cols-1){
            //System.out.println("Corner");
            return true;
        }
        boolean res = false;
        for(int d=0;d<4;d++){
            int x = i+dir[d][0];
            int y = j+dir[d][1];
            if(isValid(x,y) && board[x][y]=='O' && !visited[x][y]){
                visited[x][y] = true;
                res = res || isConnectedToBorderO(board,x,y,visited);
            }
        }
        //System.out.println("X: " + i + "  Y: " + j + "  " + res);
        return res;
    }
    private void mutateBoard(char[][] board, int i, int j){
        board[i][j] = 'X';
        for(int d=0;d<4;d++){
            int x = i+dir[d][0];
            int y = j+dir[d][1];
            if(isValid(x,y) && board[x][y]=='O') mutateBoard(board,x,y);
        }
    }
}
