class Solution {
    public static List<Integer> partitionLabels(String s) {
        int[] arr = new int[26];
        for(int i=0;i<s.length();i++) arr[s.charAt(i)-'a'] = i; //Last occurrence of a letter
        List<Integer> sizes = new ArrayList<>();
        int first = 0;
        int second = arr[s.charAt(first)-'a'];
        //System.out.println(second);
        while(second<s.length()) {
        	for(int i=first; i<second;i++) {
        		if(arr[s.charAt(i)-'a']>second) second = arr[s.charAt(i) - 'a'];
        	}
        	sizes.add(second-first+1);
        	if(second-1 == s.length()) break;
        	first = second + 1;
        	if(first == s.length()) break;
        	second = arr[s.charAt(first) - 'a'];
        }
        return sizes;
    }
}
