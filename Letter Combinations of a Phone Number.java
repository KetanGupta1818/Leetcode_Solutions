class Solution {
    List<String> listOfCharacters;
    List<String> answer = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        listOfCharacters = List.of("abc","def","ghi","jkl","mno","pqrs","tuv","wxyz");
        if(digits.length()==0) return new ArrayList<>();
        fun(new StringBuffer(),0,digits);
        return answer;
    }
    public void fun(StringBuffer cur, int index, String digits){
        if(index==digits.length()){
            answer.add(cur.toString());
            return;
        }
        String currentString = listOfCharacters.get((digits.charAt(index)-'0')-2);
        for(int i=0;i<currentString.length();i++){
            
            cur.append(currentString.charAt(i));
            fun(cur,index+1,digits);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
