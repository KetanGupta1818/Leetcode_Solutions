class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int[][] grid = new int[n][n];
        int count=0;
        for(int[] d: dig)
            grid[d[0]][d[1]]=1;
        for(int[] artifact: artifacts){
            int sum=0;
            int r1=artifact[0],c1=artifact[1],r2=artifact[2],c2=artifact[3];
            for(int r=r1;r<=r2;r++){
                for(int c=c1;c<=c2;c++){
                    sum+=grid[r][c];
                }
            }
            if(sum==(r2+1-r1)*(c2+1-c1)) count++;
        }
        return count;
    }
}
