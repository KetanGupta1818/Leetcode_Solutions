class Solution {
    public String removeStars(String s) {
        StringBuilder answer = new StringBuilder();
        int deletions = 0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='*') deletions++;
            else if(deletions>0) deletions--;
            else answer.append(s.charAt(i));
        }
        return answer.reverse().toString();
    }
}
