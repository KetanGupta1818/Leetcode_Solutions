class Solution {
    public String reverseOnlyLetters(String s) {
    	String ans = new String();
    	Stack<Character> stk = new Stack<Character>();
    	for(int i=0;i<s.length();i++) {
    		char c = s.charAt(i);
    		if(Character.isAlphabetic(c)) stk.push(c);
    	}
    	for(int i=0;i<s.length();i++) {
    		char c = s.charAt(i);
    		if(!Character.isAlphabetic(c)) ans = ans + c;
    		else ans = ans + stk.pop();
    	}
    	return ans;     
    }
}
