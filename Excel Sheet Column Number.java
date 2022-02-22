class Solution {
    public int titleToNumber(String columnTitle) {
        int answer=0;
        for(int i=0;i<columnTitle.length();i++) answer=answer*26+(columnTitle.charAt(i)-64);
        return answer;
    }
}
