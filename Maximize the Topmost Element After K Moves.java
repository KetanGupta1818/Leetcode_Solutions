class Solution {
    public int maximumTop(int[] nums, int k) {
        int n = nums.length;
        if(n==1 && k%2==1) return -1;
        if(k==0 || k==1) return nums[k];
        return Math.max(nums[k%n],IntStream.range(0,Math.min(k-1,n))
                .map(i->nums[i])
                .max()
                .getAsInt());
    }
}
