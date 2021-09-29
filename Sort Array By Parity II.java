class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int i=0,j=1;
        while(i<n && j<n){
            while(i<n && nums[i]%2==0) i=i+2;
            while(j<n && nums[j]%2==1) j=j+2;
            if(i>=n && j>=n) return nums;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i=i+2;
            j=j+2;
        }
        return nums;
    }
}
