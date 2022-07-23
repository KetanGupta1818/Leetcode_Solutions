class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> sortedNums = new ArrayList<>();
        for(int num: nums) sortedNums.add(num);
        sortedNums.sort(null);
        List<Integer> answer = new ArrayList<>();
        for(int num: nums){
            int index = firstInstanceIndex(sortedNums,num);
            answer.add(index);
            sortedNums.remove(index);
        }
        return answer;
    }
    private int firstInstanceIndex(List<Integer> sortedNums,int target){
        int lo=0,hi=sortedNums.size()-1;
        while(lo<=hi){
            int m = (lo+hi)>>1;
            if(sortedNums.get(m)>=target) hi=m-1;
            else lo=m+1;
        }
        return hi+1;
    }
}
