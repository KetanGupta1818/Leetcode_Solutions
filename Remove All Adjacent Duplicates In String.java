class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(stk.isEmpty() || stk.peek()!=s.charAt(i)) stk.push(s.charAt(i));
            else stk.pop();
        }
        StringBuffer sb = new StringBuffer();
        while(!stk.isEmpty()) sb.append(stk.pop());
        return sb.reverse().toString();
    }
}
