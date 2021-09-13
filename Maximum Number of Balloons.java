class Solution {
    public int maxNumberOfBalloons(String text) {
		HashMap<Character, Integer> hm = new HashMap<>();
		hm.put('b', 0);
		hm.put('a', 0);
		hm.put('l', 0);
		hm.put('o', 0);
		hm.put('n', 0);
		for(int i=0;i<text.length();i++) {
			char c = text.charAt(i);
			if(hm.containsKey(c)) hm.put(c, hm.get(c)+1);
		}
		//Number of balloons need to be 
		int nb = hm.get('b');
		int na = hm.get('a');
		int nl = hm.get('l')/2;
		int no = hm.get('o')/2;
		int nn = hm.get('n');
		int ans = Math.min(na, nb);
		int ans1 = Math.min(no, nn);
        return Math.min(nb, Math.min(na, Math.min(nl, Math.min(no, nn))));
    }
}
