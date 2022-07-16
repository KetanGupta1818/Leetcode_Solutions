class Solution {
    private boolean fun(int[] arr, boolean[] isSortedSubArray, int size){
        int n = arr.length;
        if(isSortedSubArray[size]) return true;
        for(int left=1,right=size;right<n-1;right++,left++){
            if(arr[right+1]>=arr[left-1] && isSortedSubArray[right+1]) return true;
            if(arr[left-1]>arr[left]) return false;
        }
        return arr[n-size-1] >= arr[n-size-2];
    }
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        boolean[] isSortedSubarray = new boolean[n];
        isSortedSubarray[n-1] = true;
        for(int i=n-2;i>=0;i--){
            if(!isSortedSubarray[i+1]) isSortedSubarray[i] = false;
            else if(arr[i]<=arr[i+1]) isSortedSubarray[i] = true;
            else isSortedSubarray[i] = false;
        }
        int lo=0,hi=n-1;
        while(lo<=hi){
            int m = (lo+hi)>>1;
            if(fun(arr,isSortedSubarray,m)) hi=m-1;
            else lo=m+1;
        }
        return hi+1;
    }
}
