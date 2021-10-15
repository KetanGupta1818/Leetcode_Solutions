class Solution {
    public static String frequencySort(String s) {
    	StringBuffer str = new StringBuffer();
    	HashMap<Character,Integer> hm = new HashMap<>();
    	for(int i=0;i<s.length();i++) hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0)+1);
    	System.out.println("HashMap: " + hm);
    	Queue<Character> heap = new PriorityQueue<>((n1,n2)->{
    		if(hm.get(n1)>hm.get(n2)) return -1;
    		return 1;
    	});
    	for(char c : hm.keySet()) heap.add(c);
    	while(!heap.isEmpty()) {
    		char c = heap.poll();
    		for(int i=0;i<hm.get(c);i++) str.append(c);
        }
    	return str.toString();
    }
}
