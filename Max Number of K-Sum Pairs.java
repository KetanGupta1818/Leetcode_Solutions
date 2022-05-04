class Solution {
    public int maxOperations(int[] nums, int k) {
        int fp=0,bp=nums.length-1,count=0;
        Arrays.sort(nums);
        while(fp<bp){
            if(nums[fp]+nums[bp] == k){
                count++;
                fp++;
                bp--;
            }
            else if(nums[fp]+nums[bp]>k) bp--;
            else fp++;
        }
        return count;
    }
}
