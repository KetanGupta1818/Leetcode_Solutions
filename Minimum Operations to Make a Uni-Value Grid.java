class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        int rem = grid[0][0]%x;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(rem!=grid[i][j]%x) return -1;
                list.add(grid[i][j]/x);
            }
        }
        if(list.size()==1) return 0;
        list.sort(null);
        if(list.size()%2==1) return f(list,list.get(list.size()/2));
        return Math.min(f(list,list.get(list.size()/2)),f(list,list.get(list.size()/2-1)));
    }
    private int f(List<Integer> list, int value){
        int sum = 0;
        for(int l: list) sum += Math.abs(value-l);
        return sum;
    }
}
