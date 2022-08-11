class Solution {
    public long countBadPairs(int[] nums) {
        Map<Long,Long> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            long dif = i-nums[i];
            map.put(dif,map.getOrDefault(dif,0L)+1L);
        }
        long sub = 0L;
        for(long key: map.keySet()){
            sub += map.get(key)*(map.get(key)-1)/2;
        }
        long n = nums.length;
        return n*(n-1)/2 - sub;
    }
}
