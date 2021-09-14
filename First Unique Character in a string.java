class Solution {
    public int firstUniqChar(String s) {
		Queue<Character> Q = new LinkedList<>();
		HashMap<Character, Integer> hm = new HashMap<>();
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(hm.containsKey(c)) hm.put(c, hm.get(c)+1);
			else {
				hm.put(c, 0);
				Q.add(c);
			}
		}
		char ans = '0';  //Default value;
		int len = Q.size();
		for(int i=0;i<len;i++) {
			char c = Q.remove();
			if(hm.get(c) == 0) {
				ans = c;
				break;
			}
		}
		if(ans == '0') return -1;
		return s.indexOf(ans);        
    }
}
