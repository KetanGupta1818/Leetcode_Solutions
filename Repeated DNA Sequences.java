class Solution {
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> answer = new ArrayList<>();
        int n = s.length();
        if(n<=10) return answer;
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0;i<=n-10;i++) {
        	String cur = s.substring(i,i+10);
        	if(hm.containsKey(cur)) hm.put(cur, hm.get(cur)+1);
        	else hm.put(cur, 1);
        	if(hm.get(cur) == 2) answer.add(cur);
        }
       return answer;
    }
}
