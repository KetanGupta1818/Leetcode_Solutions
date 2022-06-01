class Solution {
    public int[] runningSum(int[] nums) {
        int[] a = new int[nums.length];
        a[0] = nums[0];
        for(int i=1;i<a.length;i++) a[i] = a[i-1] + nums[i];
        return a;
    }
}
