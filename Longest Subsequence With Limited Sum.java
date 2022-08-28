class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] answer = new int[queries.length];
        Arrays.sort(nums);
        List<Integer> prefix = new ArrayList<>();
        prefix.add(nums[0]);
        for(int i=1;i<nums.length;i++) prefix.add(prefix.get(i-1)+nums[i]);
        for(int i=0;i<queries.length;i++){
            answer[i] = searchInsert(prefix,queries[i]);
        }
        return answer;
    }
    public static int searchInsert(List<Integer> nums, int target) {
        int lo=0,hi=nums.size()-1;
        while(lo<=hi){
            int m=lo+(hi-lo)/2;
            if(nums.get(m) >target) hi=m-1;
            else lo=m+1;
        }
        return lo;
    }
}
