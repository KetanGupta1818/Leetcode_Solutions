class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max = 0;
        for(int i=0;i<nums1.length;i++){
            max = Math.max(max,bs(i+1,nums2,nums1[i])-i);
        }
        return max;
    }
    private int bs(int lo, int[] arr, int target){
        int hi=arr.length-1;
        while(lo<=hi){
            int m = lo + (hi-lo)/2;
            if(arr[m]>=target) lo=m+1;
            else hi=m-1;
        }
        return lo-1;
    }
}
