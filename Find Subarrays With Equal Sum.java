class Solution {
    public boolean findSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length-1;i++){
            if(!set.add(nums[i]+nums[i+1])) return true;
        }
        return false;
    }
}
