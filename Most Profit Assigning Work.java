class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profits, int[] worker) {
        int n = difficulty.length,m=worker.length,profit=0;
        Queue<int[]> queue = new PriorityQueue<>((a,b)->b[1]-a[1]);
        Arrays.sort(worker);
        for(int i=0;i<n;i++) queue.offer(new int[]{difficulty[i],profits[i]});
        int lastUsedWorker = m;
        while(!queue.isEmpty()){
            int[] cur = queue.remove();
            int p = cur[1];
            int dif = cur[0];
            int pos = bs(worker,dif);
            if(m-pos>0) {
                profit += (m-pos)*p;
                m = pos;
            }
        }
        return profit;
    }
    private int bs(int[] worker, int target){
        int lo = 0, hi=worker.length-1;
        while(lo <= hi){
            int m = (lo+hi)/2;
            if(worker[m]>=target) hi=m-1;
            else lo=m+1;
        }
        return hi+1;
    }
}
