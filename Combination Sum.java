class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(new ArrayList<Integer>(),candidates,target,0,0);
        return answer;
    }
    public void helper(List<Integer> list, int[] candidates, int target, int sum,int start){
        if(sum == target){
            answer.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(sum+candidates[i]<=target){
                list.add(candidates[i]);
                helper(list,candidates,target,sum+candidates[i],i);
                list.remove(list.size()-1);
            }
            else break;
        }
    }
}
