class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k>bloomDay.length) return -1;
        int lo=1,hi=1_000_000_000;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(isPossible(bloomDay,k,mid,m)) hi = mid-1;
            else lo = mid+1;
        }
        return hi+1;
    }
    private boolean isPossible(int[] arr, int k, int time, int m){
        int bqs = 0,start = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>time) start = i+1;
            else if(i-start+1 == k) {bqs++;start=i+1;} 
        }
        return bqs>=m;
    }
}
