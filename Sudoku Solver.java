class Solution {
    public void solveSudoku(char[][] board){
        int dots = 0;
        char[][] b = new char[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                b[i][j] = board[i][j];
                if(board[i][j]=='.') dots++;
            }
        }
        backTrack(0,0,b,dots,board);
    }
    public void backTrack(int row, int col, char[][] b, int dots, char[][] board){
        if(dots==0){
            //System.out.println("Reached Answer");
            
            for(int i=0;i<9;i++){
                //System.out.println(Arrays.toString(b[i]));
                System.arraycopy(b[i], 0, board[i], 0, 9);
            }
            return;
        }
        if(row<0 || col<0 || row>=9 || col>=9) return;
        if(b[row][col]!='.'){
            if(col==8) backTrack(row+1,0,b,dots,board);
            else backTrack(row,col+1,b,dots,board);
        }
        else{
            for(int i=1;i<=9;i++){
            if(isValid(row,col,b,(char)(i+48))){
                b[row][col] = (char)(i+48);
                if(col==8) backTrack(row+1,0,b,dots-1,board);
                else backTrack(row,col+1,b,dots-1,board);
                b[row][col] = '.';
            }
        }
    }
        
    }
    public boolean isValid(int row, int col, char[][] b, char num){
        //Row check
        for(int i=0;i<9;i++){
            if(i==row) continue;
            if(b[row][i]==num) return false;
        }

        //Column check
        for(int i=0;i<9;i++){
            if(i==col) continue;
            if(b[i][col] == num) return false;
        }

        //Grid check
        for(int i=row-row%3;i<(row-row%3)+3;i++){
            for(int j=col-col%3;j<(col-col%3)+3;j++){
                if(i==row && j==col) continue;
                if(b[i][j] == num) return false;
            }
        }
        return true;
    }
}
