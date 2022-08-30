class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int prev = Integer.MIN_VALUE, answer = 0,size=0;
        for(int num: nums){
            if(prev<num) size++;
            else {
                answer = Math.max(answer,size);
                size=1;
            }
            prev = num;
        }
        return Math.max(answer,size);
    }
}
