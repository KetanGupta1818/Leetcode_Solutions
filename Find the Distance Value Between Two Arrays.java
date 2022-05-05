class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for(int num: arr1){
            int index = searchInsert(arr2,num);
            int min=Integer.MAX_VALUE;
            if(index!=0) min = Math.min(min,num-arr2[index-1]);
            if(index!=arr2.length) min = Math.min(min,arr2[index]-num);
            if(min>d) count++;
        }
        return count;
    }
    private int searchInsert(int[] nums, int target) {
        int lo=0,hi=nums.length-1;
        while(lo<=hi){
            int m=lo+(hi-lo)/2;
            if(nums[m]==target) return m;
            if(nums[m]>target) hi=m-1;
            else lo=m+1;
        }
        return lo;
    }
}
