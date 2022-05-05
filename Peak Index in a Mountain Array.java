class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int lo=0,hi=arr.length-1;
        while(lo<=hi){
            int m = lo + (hi - lo)/2;
            if(arr[m]>arr[m+1] && arr[m]>arr[m-1]) return m;
            else if(arr[m]>arr[m+1] && arr[m]<arr[m-1]) hi=m-1;
            else lo = m+1;
        }
        return -1;
    }
}
