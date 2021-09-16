class Solution {
    public String makeFancyString(String s) {
		int n = s.length();
		if(n==0 || n==1 || n==2) return s;
		StringBuffer str = new StringBuffer(s);
		int count = 0;
		for(int i=0;i<str.length()-1;i++) {
			char c1 = str.charAt(i);
			char c2 = str.charAt(i+1);
			if(c1 == c2) {
				count++;
				if(count >= 2) {
					str.deleteCharAt(i+1);
					i--;
				} 
			}
			else count = 0;
			
		}
		return str.toString(); 
    }
}
//Runtime: 2254 ms, faster than 5.01% of Java online submissions for Delete Characters to Make Fancy String.
//Memory Usage: 83.6 MB, less than 47.47% of Java online submissions for Delete Characters to Make Fancy String.
If we use a new StringBuffer string and append the values and end, then the speed of the program increases,
Runtime: 38 ms, faster than 67.40% of Java online submissions for Delete Characters to Make Fancy String.
Memory Usage: 40 MB, less than 89.90% of Java online submissions for Delete Characters to Make Fancy String.
From 2254ms to just 38ms..............
