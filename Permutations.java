class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        permutation(answer,new ArrayList<>(),nums);
        return answer;
    }
    public void permutation(List<List<Integer>> answer, List<Integer> tempList, int[] nums){
        if(tempList.size() == nums.length){
            answer.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(tempList.contains(nums[i])) continue;
            tempList.add(nums[i]);
            permutation(answer, tempList, nums);
            tempList.remove(tempList.size()-1);
        }
    }
}
