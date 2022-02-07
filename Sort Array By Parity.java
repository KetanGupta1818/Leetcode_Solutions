//quick sort style
//ep->even ponter, op->odd pointer
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n=nums.length,ep=0,op=n-1;
        while(op>ep){
            while(op>-1 && nums[op]%2==1) op--;
            while(ep<n && nums[ep]%2==0) ep++;
            if(op>ep){
                int temp = nums[ep];
                nums[ep] = nums[op];
                nums[op] = temp;
            }
        }
        return nums;
    }
}
