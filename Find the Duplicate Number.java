class Solution {
    public int findDuplicate(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i: nums){
            if(arr[i]==1) return i;
            else arr[i]++;
        }
        return -101;
    }
}
