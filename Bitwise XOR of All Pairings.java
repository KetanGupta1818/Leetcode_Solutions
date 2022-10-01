class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n1 = nums1.length,n2=nums2.length;
        if(n1%2==0 && n2%2==0) return 0;
        if(n1%2==1 && n2%2==1) return x(nums1)^x(nums2);
        if(n1%2==1) return x(nums2);
        return x(nums1);
    }
    private int x(int[] nums){
        int xor = 0;
        for(int n: nums) xor = xor^n;
        return xor;
    }
}
