class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0, max_count=0;
        for(int j: nums){
            if(j==1) count++;
            else count=0;
            if(max_count<count) max_count=count;
        }
        return max_count;
    }
}
