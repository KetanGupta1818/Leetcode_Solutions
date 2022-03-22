class Solution {
    List<String> answer = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backTrack("",0,0,n);
        return answer;
    }
    public void backTrack(String str, int open, int close, int n){
        if(str.length()==n*2) {
            answer.add(str);
            return;
        }
        if(open<n) backTrack(str+"(",open+1,close,n);
        if(close<open) backTrack(str+")",open,close+1,n);
    }
}
