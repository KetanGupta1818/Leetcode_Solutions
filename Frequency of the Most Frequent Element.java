class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int lo=1,hi=nums.length;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(isFrequencyPossible(nums,mid,k)) lo=mid+1;
            else hi=mid-1;
        }
        return lo-1;
    }
    private boolean isFrequencyPossible(int[] arr, int frequency, long maximumIncrements){
        long currentIncrements = 0L;
        for(int i=0;i<frequency-1;i++) currentIncrements += (arr[frequency-1]-arr[i]);
        if(currentIncrements <= maximumIncrements) return true;
        for(int left=0,right=frequency;right<arr.length;right++,left++){
            currentIncrements -= (arr[right-1]-arr[left]);
            currentIncrements += (long) (arr[right] - arr[right - 1]) *(frequency-1);
            if(currentIncrements <= maximumIncrements) return true;
        }
        return false;
    }
}    
