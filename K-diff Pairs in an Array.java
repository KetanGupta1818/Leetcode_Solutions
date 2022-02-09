class Solution {
     public int findPairs(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i: nums) map.put(i,map.getOrDefault(i,0)+1);
        if(k==0) return (int)map.keySet().stream().filter(key->map.get(key)>1).count();
        return (int)map.keySet().stream().filter(key->map.containsKey(key+k)).count();
    }
}
