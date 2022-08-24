class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length,right=0,answer = 0;
        long product = 1;
        for(int left=0;left<n;left++){
            while(right<n && nums[right]*product<k) {
                product *= nums[right];
                right++;
            }
            if(right<=left){
                right=left+1;
                continue;
            }
            product = product/nums[left];
            int size = right-left;
            answer += size;
        }
        return answer;
    }
}
