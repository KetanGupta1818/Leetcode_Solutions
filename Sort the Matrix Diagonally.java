class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int cols=mat[0].length,rows=mat.length;
        for(int r=0;r<rows;r++){
            Queue<Integer> queue = new PriorityQueue<>();
            int cr=r,cc=0;
            while(cr<rows && cc<cols){
                queue.offer(mat[cr++][cc++]);
            }
            cr=r;cc=0;
            while(cr<rows && cc<cols){
                mat[cr++][cc++] = queue.remove();
            }
        }
        for(int c=1;c<cols;c++){
            Queue<Integer> queue = new PriorityQueue<>();
            int cr=0,cc=c;
            while(cr<rows && cc<cols){
                queue.offer(mat[cr++][cc++]);
            }
            cr=0;cc=c;
            while(cr<rows && cc<cols){
                mat[cr++][cc++] = queue.remove();
            }
        }
        return mat;
    }
}
