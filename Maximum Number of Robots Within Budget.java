class Solution {
    long[] prefixSum;
    MaxSparseTable maxSparseTable;
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        maxSparseTable = new MaxSparseTable(chargeTimes);
        prefixSum = new long[n];
        prefixSum[0] = runningCosts[0];
        for(int i=1;i<n;i++) prefixSum[i] = prefixSum[i-1]+runningCosts[i];
        int lo=1,hi=n;
        while(lo<=hi){
            int m = (lo+hi)/2;
            if(canSubArraySizeBeM(m,budget,n)) lo=m+1;
            else hi=m-1;
        }
        return lo-1;
    }
    private long sumInRange(int left, int right){
        if(left==0) return prefixSum[right];
        return prefixSum[right]- prefixSum[left-1];
    }
    private boolean canSubArraySizeBeM(int m, long budget,int n){
        for(int left=0,right=m-1;right<n;right++,left++){
            if(sumInRange(left,right)*m+maxSparseTable.getMaximum(left,right)<=budget) return true;
        }
        return false;
    }
}
class MaxSparseTable{
    int n;
    int[] logs;
    int[] arr;
    int[][] table;
    MaxSparseTable(int[] a){
        this.n = a.length;
        this.arr = new int[n];
        for(int i=0;i<a.length;i++) arr[i] = a[i];
        int maxPowerOfTwo = (int)Math.ceil(Math.log(n)/Math.log(2));
        this.logs = new int[n+1];
        computeLogs();
        this.table = new int[maxPowerOfTwo+1][n];
        for(int i=0;i<=logs[n];i++){
            int curLen = 1<<i;
            for(int j=0;j+curLen<=n;j++){
                if(curLen==1) table[i][j] = arr[j];
                else table[i][j] = Math.max(table[i-1][j],table[i-1][j+(curLen/2)]);
            }
        }
    }
    private void computeLogs(){
        for(int i=2;i<=n;i++) logs[i] = logs[i/2]+1;
    }
    public int getMaximum(int left, int right){
        int p = logs[right-left+1];
        int pLen = 1 << p;
        return Math.max(table[p][left],table[p][right-pLen+1]);
    }
}
