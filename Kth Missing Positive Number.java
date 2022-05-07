class Solution {
    public int findKthPositive(int[] arr, int k) {
        int num=1;
        while(k>0){
            if(!bs(num++,arr)) k--;
        }
        return num-1;
    }
    private boolean bs(int target, int[] arr){
        int lo=0,hi=arr.length-1;
        while(lo<=hi){
            int m = lo + (hi-lo)/2;
            if(arr[m]==target) return true;
            else if(arr[m]>target) hi=m-1;
            else lo=m+1;
        }
        return false;
    }
}
