
class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] dif = new int[n];
        for(int i=1;i<n;i++){
            dif[i] = nums[i-1]-nums[i];
        }
        List<Integer> answer = new ArrayList<>();
        if(k == 1) {
            for(int i=1;i<n-1;i++)answer.add(i);
            return answer;
        }
        MinSparseTable minSparseTable = new MinSparseTable(dif);
        MaxSparseTable maxSparseTable = new MaxSparseTable(dif);
        for(int i=k;i<n-k;i++){
            if(minSparseTable.getMinimum(i-k+1,i-1)>=0 && maxSparseTable.getMaximum(i+2,i+k)<=0) answer.add(i);
        }
        return answer;
    }

}
class MinSparseTable{
    int n;
    int[] logs;
    int[] arr;
    int[][] table;
    MinSparseTable(int[] a){
        this.n = a.length;
        this.arr = new int[n];
        for(int i=0;i<a.length;i++) arr[i] = a[i];
        int maxPowerOfTwo = Math.max(1,(int)Math.ceil(Math.log(n)/Math.log(2)));
        this.logs = new int[n+1];
        computeLogs();
        this.table = new int[maxPowerOfTwo+1][n];
        for(int i=0;i<=logs[n];i++){
            int curLen = 1<<i;
            for(int j=0;j<=n-curLen;j++){
                if(curLen==1) table[i][j] = arr[j];
                else table[i][j] = Math.min(table[i-1][j],table[i-1][j+(curLen/2)]);
            }
        }
    }
    private void computeLogs(){
        for(int i=2;i<=n;i++) logs[i] = logs[i/2]+1;

    }
    public int getMinimum(int left, int right){
        int p = logs[right-left+1];
        int pLen = 1 << p;
        return Math.min(table[p][left],table[p][right-pLen+1]);
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
        int maxPowerOfTwo = Math.max(1,(int)Math.ceil(Math.log(n)/Math.log(2)));
        this.logs = new int[n+1];
        computeLogs();
        this.table = new int[maxPowerOfTwo+1][n];
        for(int i=0;i<=logs[n];i++){
            int curLen = 1<<i;
            for(int j=0;j<=n-curLen;j++){
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
