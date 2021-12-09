class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        calculator(answer,new ArrayList<>(),1,n,k);
        return answer;
    }
    public void calculator(List<List<Integer>> answer, List<Integer> combine, int lowerbound, int n, int k){
        if(k==0){
            answer.add(new ArrayList<>(combine));
            return;
        }
        for(int i=lowerbound;i<=n;i++){
            combine.add(i);
            calculator(answer,combine,i+1,n,k-1);
            combine.remove(combine.size()-1);
        }
    }
}
