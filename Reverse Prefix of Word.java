class Solution {
    public String reversePrefix(String word, char ch) {
		String ans = new String(); //The answer String
		Stack<Character> stk = new Stack<>(); 
		int i=0;
		while(i<word.length() && word.charAt(i)!=ch) {
			stk.push(word.charAt(i));
			i++;
		}
		if(i==word.length()) return word;
		stk.push(word.charAt(i));
		while(!stk.isEmpty()) ans = ans + stk.pop();
		ans = ans + word.substring(i+1);
		return ans;        
    }
}
