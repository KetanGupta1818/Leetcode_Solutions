class Solution {
    public static boolean wordPattern(String pattern, String s) {
    	String[] ss = s.split(" ");
    	if(pattern.length()!=ss.length) return false;
    	HashSet<Character> hs = new HashSet<>();
    	HashMap<String, Character> hm = new HashMap<>();
    	for(int i=0;i<ss.length;i++) {
    		if(hm.containsKey(ss[i])) {
    			if(hm.get(ss[i]) != pattern.charAt(i)) return false;
    		}
    		else {
    			if(hs.contains(pattern.charAt(i))) return false;
    			hs.add(pattern.charAt(i));
    			hm.put(ss[i], pattern.charAt(i));
    		}
    	}
    	return true;
    }
}
