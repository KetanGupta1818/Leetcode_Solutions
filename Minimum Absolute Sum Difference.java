class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        long[] absoluteDifferences = new long[n];
        for(int i=0;i<n;i++) 
            absoluteDifferences[i] = Math.abs(nums1[i] - nums2[i]);
        Arrays.sort(nums1);
        long maxDif = 0;
        int changeIndex = -1;
        for(int i=0;i<n;i++){
            int index = bs(nums1,nums2[i]);
            if(index != -1){
                if(maxDif <  absoluteDifferences[i]-Math.abs(nums1[index]-nums2[i])){
                    maxDif =  absoluteDifferences[i]-Math.abs(nums1[index]-nums2[i]);
                    changeIndex = i;
                }
            }
            if(index!=n-1){
                if(maxDif <  absoluteDifferences[i]-Math.abs(nums1[index+1]-nums2[i])){
                    maxDif =  absoluteDifferences[i]-Math.abs(nums1[index+1]-nums2[i]);
                    changeIndex = i;
                }
            }
        }
        if(changeIndex != -1) absoluteDifferences[changeIndex] -= maxDif;
        long ans = 0L;
        for(long abs: absoluteDifferences) ans = (abs + ans)%1_000_000_007;
        return (int)ans;
    }
    private int bs(int[] arr, int target){
        int lo=0, hi=arr.length-1;
        while(lo <= hi){
            int m = (lo+hi)/2;
            if(arr[m] >= target) hi=m-1;
            else lo=m+1;
        }
        return hi;
    }
}
