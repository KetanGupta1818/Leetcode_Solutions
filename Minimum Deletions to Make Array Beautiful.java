class Solution {
    public int minDeletion(int[] nums) {
        int size=0;
        int n = nums.length;
        int c = 0;
        boolean even = true;
        for(int i=0;i<nums.length;i++){
            while(i<nums.length-1 && even && nums[i]==nums[i+1]){
                i++;
                c++;
            }
            even = !even;
            size++;
        }
        return c + size%2;
    }
}
