class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> countIndexMap = new HashMap<>();
        int count=0,maxLen=0;
        countIndexMap.put(count,-1);
        for(int i=0;i<n;i++){
            if(nums[i]==1) count++;
            else count--;
            if(countIndexMap.containsKey(count)) maxLen=Math.max(maxLen,i-countIndexMap.get(count));
            else countIndexMap.put(count,i);
        }
        return maxLen;
    }
}
