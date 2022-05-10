class Solution {
    private List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        fun(1,new ArrayList<>(),k,n);
        return answer;
    }
    private void fun(int start, List<Integer> curList,int k, int n){
        if(curList.size()==k){
            if(n==0) answer.add(new ArrayList<>(curList));
            return;
        }
        for(int i=start;i<=9;i++){
            curList.add(i);
            fun(i+1,curList,k,n-i);
            curList.remove(curList.size()-1);
        }
    }
}
