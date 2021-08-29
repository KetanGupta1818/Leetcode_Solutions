class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char temp1, temp2;
            temp1 = s.charAt(i);
            if(temp1=='('||temp1=='['||temp1=='{') stk.push(temp1);
            else{
                if(stk.isEmpty()) return false;
                else{
                    temp2 = stk.pop();
                    if(!isMatch(temp2, temp1)) return false;
                }
            }
        }
        if(stk.isEmpty()) return true;
        return false;
    }
    public boolean isMatch(char a, char b){
        if(a=='(' && b==')') return true;
        else if(a=='[' && b==']') return true;
        else if(a=='{' && b=='}') return true;
        else return false;
    }
}
