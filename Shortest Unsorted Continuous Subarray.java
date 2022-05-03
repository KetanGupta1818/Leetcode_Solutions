class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] arr = new int[nums.length];
        System.arraycopy(nums,0,arr,0,nums.length);
        Arrays.sort(arr);
        int start=0,end=nums.length-1;
        while(start<=end && nums[start]==arr[start]) start++;
        if(start>end) return 0;
        while(end>=0 && nums[end]==arr[end]) end--;
        return end-start+1;
    }
}
