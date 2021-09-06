class Solution {
	public int countSegments(String s) {
		if(s.length() == 0) return 0;
        int count=0,i=0;
        int n = s.length();
        while(i<n) {
        	if(s.charAt(i) == ' ') {
        		count++;
        		while(i<n && s.charAt(i) == ' ') i++;
        		continue;
        	}
        	i++;
        }
        if(s.charAt(0) == ' ') count--;
        if(s.charAt(s.length()-1) == ' ') count--;
        return count + 1;
    }	

}
