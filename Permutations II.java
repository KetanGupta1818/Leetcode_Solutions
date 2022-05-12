class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        HashMap<Integer,Integer> counter = new HashMap<>();
        for(int num: nums) counter.put(num,counter.getOrDefault(num,0)+1);
        backTrack(counter,answer,new LinkedList<>(),nums.length);
        return answer;
    }
    private void backTrack(HashMap<Integer,Integer> counter, List<List<Integer>> answer, LinkedList<Integer> curList, int n){
        if(curList.size() == n){
            answer.add(new ArrayList<>(curList));
            return;
        }
        for(Map.Entry<Integer,Integer> entry: counter.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();
            if(count == 0) continue;
            curList.add(num);
            counter.put(num,count-1);
            backTrack(counter,answer,curList,n);
            curList.removeLast();
            counter.put(num,count);
        }
    }
}
