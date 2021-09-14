//Using HashMap
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
		HashMap<Character, Integer> hm = new HashMap<>();
		if(ransomNote.length()>magazine.length()) return false;
		for(int i=0;i<magazine.length();i++) {
			char c = magazine.charAt(i);
			if(hm.containsKey(c)) hm.put(c, hm.get(c)+1);
			else hm.put(c, 1);
		}
		for(int i=0;i<ransomNote.length();i++) {
			char c = ransomNote.charAt(i);
			if(!hm.containsKey(c) || hm.get(c) == 0) return false;
            else hm.put(c, hm.get(c)-1);
		}
		return true;        
    }
}
//Using array
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for(int i=0;i<magazine.length();i++) arr[magazine.charAt(i) - 'a']++;
        for(int i=0;i<ransomNote.length();i++) if(--arr[ransomNote.charAt(i) - 'a'] < 0) return false;
        return true;
    }
}
