class Solution {
	public static int romanToInt(String s) {
	    HashMap<Character,Integer> hm = new HashMap<>();
	    hm.put('I', 1);
	    hm.put('V', 5);
	    hm.put('X', 10);
	    hm.put('L', 50);
	    hm.put('C', 100);
	    hm.put('D', 500);
	    hm.put('M', 1000);
	    int answer = 0;
	    for(int i=0;i<s.length()-1;i++) {
	    	char c_current = s.charAt(i);
	    	char c_next = s.charAt(i+1);
	    	if(hm.get(c_current)<hm.get(c_next)) answer = answer - hm.get(c_current);
	    	else answer = answer + hm.get(c_current);
	    }
	    answer = answer + hm.get(s.charAt(s.length()-1));
	    return answer;
	}
}
