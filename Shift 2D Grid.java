class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        int m = grid.length,n=grid[0].length;
        for(int i=0;i<m;i++) {
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<n;j++){
                list.add(-1);
            }
            answer.add(list);
        }
        for(int i=0;i<m*n;i++){
            if(k>=m*n) k%=m*n;
            answer.get(k/n).set(k%n,grid[i/n][i%n]);
            k++;
        }
        return answer;
    }
}
