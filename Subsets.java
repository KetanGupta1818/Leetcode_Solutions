class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<>();
        subsetCreator(0,new ArrayList<>(),nums);
        return answer;
    }
    public void subsetCreator(int start, List<Integer> currentList,int[] nums){
        answer.add(new ArrayList<>(currentList));
        for (int i=start;i<nums.length;i++){
            currentList.add(nums[i]);
            subsetCreator(i+1,currentList,nums);
            currentList.remove(currentList.size()-1);
        }
    }
}
