class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if(len==k) return "0";
        Stack<Character> stk = new Stack<>();
        int i=0;
        while(i<num.length()){
        while(k>0 && !stk.isEmpty() && stk.peek()>num.charAt(i)){
            stk.pop();
            k--;
        }
        stk.push(num.charAt(i));
        i++;
        }
        while(k>0){
            stk.pop();
            k--;
        }
        StringBuffer sb = new StringBuffer();
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        sb.reverse();
        while(sb.length()>0 && sb.charAt(0)=='0') sb.deleteCharAt(0);
        if(sb.length()==0) return "0";
        return sb.toString();
    }
}
