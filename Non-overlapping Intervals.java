class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>(){
            
            @Override
            public int compare(int[] a,int[] b){
                return a[0] - b[0];
            }
        });
        int prevEnd = intervals[0][1];
        int result = 0;
        for(int i = 1; i < intervals.length; i++){
            if(prevEnd <= intervals[i][0]){
                prevEnd = intervals[i][1];
            }
            else if (prevEnd > intervals[i][0] && prevEnd >= intervals[i][1]){
                 result++;
                 prevEnd = intervals[i][1];
            }
            else {
                result++;
            }
        }
        return result;
    }
}
/**************************************************************************************Method 2
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        for(int i=0;i<intervals.length;i++)System.out.println(intervals[i][0]+" "+intervals[i][1]);
        int ans=0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i-1][1]<=intervals[i][0]) intervals[i][0] = intervals[i-1][0];
            else if(intervals[i-1][1]>=intervals[i][1] && intervals[i-1][1]>intervals[i][0]){
                ans++;
            }
            else{
                ans++;
                intervals[i][0] = intervals[i-1][0];
                intervals[i][1] = intervals[i-1][1];
            } 
        }
        return ans;
    }
}
