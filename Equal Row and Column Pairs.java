class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int counter = 0;
        for(int i=0;i<n;i++){
            int[] arr = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = grid[i][j];
            }
            c: for(int c=0;c<n;c++){
                for(int r=0;r<n;r++){
                    if(grid[r][c]!=arr[r]) continue c;
                }
                counter++;
            }
        }
        return counter;
    }
}
