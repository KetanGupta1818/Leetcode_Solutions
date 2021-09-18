class Solution {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
    	int n = s.length();
    	for(int i=0;i<n;i++) {
    		if(s.charAt(i)!=s.charAt(n-i-1)) return false;
    	}
    	return true;
    }
}
