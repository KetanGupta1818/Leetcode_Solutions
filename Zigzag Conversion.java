class Solution {
    public String convert(String s, int numRows) {
        char[][] grid = new char[numRows][s.length()];
        for(int i=0;i<numRows;i++) for(int j=0;j<s.length();j++) grid[i][j] = '{';
        int index = 0,c=0;
        main: while(index<s.length()){
            for(int r=0;r<numRows;r++) {
                grid[r][c] = s.charAt(index++);
                if(index == s.length()) break main;
            }
            for(int r=numRows-2;r>=1;r--){
                grid[r][++c] = s.charAt(index++);
                if(index == s.length()) break main;
            }
            c++;
        }
        StringBuilder sb = new StringBuilder();
        for(char[] g: grid){
            for(char ch: g) if(ch!='{') sb.append(ch);
        }
        return sb.toString();
    }
}
