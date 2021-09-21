class Solution {
    public String tictactoe(int[][] moves) {
        int[][] answer_matrix = {{0,0,0},{0,0,0},{0,0,0}};
        //Put 1 for moves of A
        for(int i=0;i<moves.length;i=i+2){
            answer_matrix[moves[i][0]][moves[i][1]] = 1;
        }
        //Put -1 for moves of B
        for(int i=1;i<moves.length;i=i+2){
            answer_matrix[moves[i][0]][moves[i][1]] = -1;
        }
        //Calculation of sum of rows and columns
        for(int i=0;i<=2;i++){
            int sum_col=0,sum_row=0;
            for(int j=0;j<=2;j++){
                sum_col+=answer_matrix[j][i];
                sum_row+=answer_matrix[i][j];
            }
            if(sum_col==3 || sum_row==3) return "A";
            if(sum_col==-3 || sum_row==-3) return "B";
        }
        //Checking the sum of diagonals
        int d1 = answer_matrix[0][0]+answer_matrix[1][1]+answer_matrix[2][2];
        int d2 = answer_matrix[0][2]+answer_matrix[1][1]+answer_matrix[2][0];
        if(d1==3 || d2==3) return "A";
        if(d1==-3 || d2==-3) return "B";
        //All 9 moves were made but still no winner, so it is a draw
        if(moves.length==9) return "Draw";
        //All 9 nine moves are not made.
        else return "Pending";
    }
}
