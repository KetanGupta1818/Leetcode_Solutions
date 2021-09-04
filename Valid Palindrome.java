class Solution {
    public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		StringBuffer str = new StringBuffer();
		for(int i=0;i<s.length();i++) {
			if(Character.isLetterOrDigit(s.charAt(i))) {
				str.append(s.charAt(i));
			} 
		}
		System.out.println("\n" + str);
		int n = str.length();
		if(n%2 == 0) {
			int mid = n/2;
			Stack<Character> stk = new Stack<Character>();
			for(int i=0;i<mid;i++) stk.push(str.charAt(i));
			for(int i=mid;i<n;i++) {
				if(stk.pop() != str.charAt(i)) {
					return false;
				}
			if(i==n-1) return true;
			}
		}
		else {  // The length is odd.
			int mid = n/2;
			Stack<Character> stk = new Stack<Character>();
			for(int i=0;i<mid;i++) stk.push(str.charAt(i));
			for(int i=mid+1;i<n;i++) {
				if(stk.pop() != str.charAt(i)) {
					return false;
				}
			if(i==n-1) return true;
			

		}
        return true;
    }
}
