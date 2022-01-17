class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n<2) return nums.length;
        int prevDiff = nums[1] - nums[0];
        int count = prevDiff!=0 ? 2:1;
        for(int i=2;i<n;i++){
            int dif = nums[i] - nums[i-1];
            if((dif>0 && prevDiff<=0) || (dif<0 && prevDiff>=0)) {
                count++;
                prevDiff = dif;
            }
        }
        return count;
    }
}
