class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(backTrack(i,j,0,board,word)) return true;
            }
        }
        return false;
    }
    public boolean backTrack(int row, int col, int index, char[][] board, String word){
        if(index==word.length()) return true;
        if(row<0 || row>=board.length|| col<0 || col>=board[0].length) return false;
        char wordLetter = word.charAt(index);
        if(board[row][col]!=wordLetter) return false;
        board[row][col] = '.';
        boolean result = backTrack(row+1,col,index+1,board,word) ||
                backTrack(row,col+1,index+1,board,word) || 
                backTrack(row-1,col,index+1,board,word) ||
                backTrack(row,col-1,index+1,board,word);
        board[row][col] = wordLetter;
        return result;
        
    }
}
