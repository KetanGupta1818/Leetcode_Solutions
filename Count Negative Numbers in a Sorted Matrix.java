class Solution {
    public int countNegatives(int[][] grid) {
        int answer = 0;
        for(int[] g: grid){
            answer += (grid[0].length - bs(g)); 
        }
        return answer;
    }
    private int bs(int[] arr){
        int lo=0,hi=arr.length-1;
        while(lo<=hi){
            int m = lo + (hi-lo)/2;
            if(arr[m]>=0) lo=m+1;
            else hi=m-1;
        }
        return lo;
    }
}
