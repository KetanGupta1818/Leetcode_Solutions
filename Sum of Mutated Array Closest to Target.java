class Solution {
    public int findBestValue(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);
        int[] ps = new int[n];
        ps[0] = arr[0];
        for(int i=1;i<n;i++) ps[i] = ps[i-1]+arr[i];
        int min = Integer.MAX_VALUE;
        int i = -1;
        for(int t=0;t<=target;t++){
            int index = bs(arr,t);
            int sum = 0;
            if(index!=0) sum = ps[index-1];
            sum += t*(n-index);
            if(min > Math.abs(sum-target)){
                min = Math.abs(sum - target);
                i = t;
            }
        }
        return i;
    }
    private int bs(int[] nums, int target){
        int lo=0,hi=nums.length-1;
        while(lo <= hi){
            int m = (lo+hi)>>1;
            if(nums[m]>=target) hi=m-1;
            else lo=m+1;
        }
        return lo;
    }
}
