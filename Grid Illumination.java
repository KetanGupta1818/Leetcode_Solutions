class Solution {
    int[][] dir = {{0,0},{0,1},{0,-1},{1,0},{1,1},{1,-1},{-1,0},{-1,1},{-1,-1}};
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Map<Integer,Integer> rowCount = new HashMap<>();
        Map<Integer,Integer> colCount = new HashMap<>();
        Map<Integer,Integer> slopeOneDiagonals = new HashMap<>();
        Map<Integer,Integer> slopeMinusOneDiagonals = new HashMap<>();
        Map<Long,Boolean> turnedOn = new HashMap<>();

        int[] arr = new int[queries.length];

        for(int[] lamp: lamps){
            int x = lamp[0];
            int y = lamp[1];

            if(turnedOn.containsKey((long)n*(long)x+y)) continue;
            rowCount.put(x,rowCount.getOrDefault(x,0)+1);
            colCount.put(y,colCount.getOrDefault(y,0)+1);
            slopeOneDiagonals.put(x+y,slopeOneDiagonals.getOrDefault(x+y,0)+1);
            slopeMinusOneDiagonals.put(x-y,slopeMinusOneDiagonals.getOrDefault(x-y,0)+1);
            turnedOn.put((long)n*(long)x+y,true);
        }

        for(int i=0;i<arr.length;i++){
            int x = queries[i][0];
            int y = queries[i][1];
            arr[i] = (rowCount.getOrDefault(x,0)>0 || colCount.getOrDefault(y,0)>0 || slopeMinusOneDiagonals.getOrDefault(x-y,0)>0
            || slopeOneDiagonals.getOrDefault(x+y,0)>0) || turnedOn.getOrDefault((long)n*(long)x+y,false)?1:0;
            for (int[] ints : dir) {
                int cur_x = x + ints[0];
                int cur_y = y + ints[1];
                if (isValid(cur_x, cur_y, n) && turnedOn.getOrDefault((long) n * (long) cur_x + cur_y, false)) {
                    rowCount.put(cur_x, rowCount.get(cur_x) - 1);
                    colCount.put(cur_y, colCount.get(cur_y) - 1);
                    slopeOneDiagonals.put(cur_x + cur_y, slopeOneDiagonals.get(cur_x + cur_y)-1);
                    slopeMinusOneDiagonals.put(cur_x - cur_y, slopeMinusOneDiagonals.get(cur_x - cur_y)-1);
                    
                    turnedOn.put((long) n * (long) cur_x + cur_y, false);
                }
            }
        }
        return arr;
    }
    private boolean isValid(int i, int j, int n){
        return i>=0 && j>=0 && i<n && j<n;
    }
}
