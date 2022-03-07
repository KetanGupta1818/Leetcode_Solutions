class Solution {
    public int mostFrequent(int[] nums, int key) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]!=key) continue;
            map.put(nums[i+1],map.getOrDefault(nums[i+1],0)+1);
        }
        int maxKey=0, maxFreq=Integer.MIN_VALUE;
        for(int k: map.keySet()){
            if(map.get(k)>maxFreq) {
                maxKey=k;
                maxFreq=map.get(k);
            }
        }
        return maxKey;
    }
}
