class Solution {
    public boolean isValidSudoku(char[][] board) {
        int i,j,k,l;
        HashSet<Character> hashset1 = new HashSet<>();
        HashSet<Character> hashset2 = new HashSet<>();
        HashSet<Character> hashset3 = new HashSet<>();
        for(i=0;i<9;i++){
            for(j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                if(hashset1.contains(board[i][j])) return false;
                else hashset1.add(board[i][j]);
            }
            hashset1.clear();
        }
        for(i=0;i<9;i++){
            for(j=0;j<9;j++){
                if(board[j][i]=='.') continue;
                if(hashset2.contains(board[j][i])) return false;
                else hashset2.add(board[j][i]);
            }
            hashset2.clear();
        }
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                if(board[i][j]=='.') continue;
                if(hashset3.contains(board[i][j])) return false;
                else hashset3.add(board[i][j]);
                }
        }
        hashset3.clear();
        for(i=0;i<3;i++){
            for(j=3;j<6;j++){
                if(board[i][j]=='.') continue;
                if(hashset3.contains(board[i][j])) return false;
                else hashset3.add(board[i][j]);
                }
        }
        hashset3.clear();            
         for(i=0;i<3;i++){
            for(j=6;j<9;j++){
                if(board[i][j]=='.') continue;
                if(hashset3.contains(board[i][j])) return false;
                else hashset3.add(board[i][j]);
                }
        }
        hashset3.clear(); 
        for(i=3;i<6;i++){
            for(j=0;j<3;j++){
                if(board[i][j]=='.') continue;
                if(hashset3.contains(board[i][j])) return false;
                else hashset3.add(board[i][j]);
                }
        }
        hashset3.clear(); 
        for(i=3;i<6;i++){
            for(j=3;j<6;j++){
                if(board[i][j]=='.') continue;
                if(hashset3.contains(board[i][j])) return false;
                else hashset3.add(board[i][j]);
                }
        }
        hashset3.clear(); 
        for(i=3;i<6;i++){
            for(j=6;j<9;j++){
                if(board[i][j]=='.') continue;
                if(hashset3.contains(board[i][j])) return false;
                else hashset3.add(board[i][j]);
                }
        }
        hashset3.clear(); 
        for(i=6;i<9;i++){
            for(j=0;j<3;j++){
                if(board[i][j]=='.') continue;
                if(hashset3.contains(board[i][j])) return false;
                else hashset3.add(board[i][j]);
                }
        }
        hashset3.clear(); 
        for(i=6;i<9;i++){
            for(j=3;j<6;j++){
                if(board[i][j]=='.') continue;
                if(hashset3.contains(board[i][j])) return false;
                else hashset3.add(board[i][j]);
                }
        }
        hashset3.clear(); 
        for(i=6;i<9;i++){
            for(j=6;j<9;j++){
                if(board[i][j]=='.') continue;
                if(hashset3.contains(board[i][j])) return false;
                else hashset3.add(board[i][j]);
                }
        }
        hashset3.clear(); 
        return true;
    }
}
//Second method: Here only one Hashtable is used.
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> hs = new HashSet<String>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                String row_str = new String("row"+i+"["+board[i][j]+"]");
                String col_str = new String("column"+j+"["+board[i][j]+"]");
                String block_str = new String("block"+i/3+j/3+"["+board[i][j]+"]");
                if(hs.contains(row_str)) return false;
                else hs.add(row_str);
                if(hs.contains(col_str)) return false;
                else hs.add(col_str);
                if(hs.contains(block_str)) return false;
                else hs.add(block_str);
                
            }
        }
        return true;
    }
}
