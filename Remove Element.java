class Solution {
    public int removeElement(int[] nums, int val) {
        int i=0,j=0;
        for(j=0;j<nums.length;j++){
            if(nums[j]!=val){
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }
        
}
