class Solution {
    public int lengthOfLastWord(String s) {
		Stack<Character> stk = new Stack<Character>();
		int count = 0;
		int last_word = 0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==' ') {
				count = 0;
				stk.clear();
			}
			else {
				stk.push(s.charAt(i));
				count = count + 1;
				last_word = count;
			}
		}
        return last_word;
    }
}
