class Solution {
    public int lengthOfLongestSubstring(String s) {
		int max_count = 0;
		HashMap<Character, Integer> ht = new HashMap<Character, Integer>();
		HashMap<Character, Integer> htnew = new HashMap<Character, Integer>();
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			if(ht.containsKey(ch)) {
				int gape = i - ht.get(ch) - 1;
				for(int j=1;j<=gape;j++) htnew.put(s.charAt(j+ht.get(ch)), j+ht.get(ch));
				htnew.put(ch, i);
				ht.clear();
				ht.putAll(htnew);
				htnew.clear();
			}
			else ht.put(ch, i);
			if(max_count < ht.size()) max_count = ht.size();
		}  
        return max_count;
    }
}
