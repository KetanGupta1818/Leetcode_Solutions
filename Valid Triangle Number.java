class Solution {
    public int triangleNumber(int[] nums) {
        int ans = 0, n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++)
                ans += bs(j+1,n-1,nums,nums[i]+nums[j]) - j;
        }
        return ans;
    }
    private int bs(int lo, int hi, int[] arr, int target){
        while(lo<=hi){
            int m = (lo+hi)/2;
            if(arr[m]>=target) hi=m-1;
            else lo=m+1;
        }
        return hi;
    }
}
