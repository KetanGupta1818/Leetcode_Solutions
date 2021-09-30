class Solution {
    public static int longestPalindrome(String s) {
    	HashMap<Character, Integer> hm = new HashMap<>();
    	int lps = 0;
    	for(int i=0;i<s.length();i++) {
    		char c = s.charAt(i);
    		if(hm.containsKey(c)) {
    			hm.put(c, hm.get(c)+1);
    			if(hm.get(c)%2==0) lps = lps+2;
    		}
    		else hm.put(c, 1);
    	}
    	if(lps==s.length()) return lps;
    	else return (lps+1);
    }
}
