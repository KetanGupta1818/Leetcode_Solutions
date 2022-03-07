class Solution {
    public List<String> cellsInRange(String s) {
        int col1 = (int)s.charAt(0);
        int col2 = (int)s.charAt(3);
        int row1 = (int)s.charAt(1)-'0';
        int row2 = (int)s.charAt(4)-'0';
        List<String> answer = new ArrayList<>();
        for(int c=col1;c<=col2;c++){
            for(int r=row1;r<=row2;r++){
                answer.add((char)c+""+r);
            }
        }
        return answer;
    }
}
