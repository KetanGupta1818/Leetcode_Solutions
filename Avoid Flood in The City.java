class Solution {
     public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] answer = new int[n];
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.fill(answer,-1);
        List<Integer> dryDays = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(rains[i] == 0){
                dryDays.add(i);
                continue;
            }
            if(map.containsKey(rains[i])){
                int prevDay = map.get(rains[i]);
                int insertPos = searchInsert(dryDays,prevDay);
                if(insertPos == dryDays.size()) return new int[]{};
                answer[dryDays.remove(insertPos)] = rains[i];
            }
            map.put(rains[i],i);
        }
        for(int l: dryDays) answer[l] = 1;
        return answer;
    }
    public int searchInsert(List<Integer> nums, int target) {
        int lo=0,hi=nums.size()-1;
        while(lo<=hi){
            int m=lo+(hi-lo)/2;
            if(nums.get(m) ==target) return m;
            if(nums.get(m) >target) hi=m-1;
            else lo=m+1;
        }
        return lo;
    }
}
