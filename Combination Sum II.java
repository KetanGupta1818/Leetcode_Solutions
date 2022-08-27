class Solution {
    private List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        fun(0,candidates,target,new ArrayList<>());
        return answer;
    }
    private void fun(int index, int[] candidates, int sum,List<Integer> list){
        if(sum==0){
            answer.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(i!=index && candidates[i]==candidates[i-1]) continue;
            if(sum<candidates[i]) return;
            list.add(candidates[i]);
            fun(i+1,candidates,sum-candidates[i],list);
            list.remove(list.size()-1);
        }
    }
}
