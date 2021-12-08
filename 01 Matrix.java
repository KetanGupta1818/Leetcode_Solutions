//BFS Solution
class Solution {
    int[] direction = new int[]{0,1,0,-1,0};
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int columns = mat[0].length;
        if(rows==0) return mat;
        Queue<int[]> q = new ArrayDeque<>();
        for(int r=0;r<rows;r++){
            for(int c=0;c<columns;c++){
                if(mat[r][c]==0) q.offer(new int[]{r,c});
                else mat[r][c] = -1;
            }
        }
        while(!q.isEmpty()){
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];
            for(int i=0;i<4;i++){
                int nr = r + direction[i];
                int nc = c + direction[i+1];
                if(nr<0||nc<0||nr>=rows||nc>=columns||mat[nr][nc]!=-1) continue;
                mat[nr][nc] = mat[r][c]+1;
                q.offer(new int[]{nr,nc});
            }
        }
        return mat;
    }
}
