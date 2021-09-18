class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> ans = new ArrayList<>();
		HashMap<String, List<String>> hm = new HashMap<>();
		Stack<String> stk = new Stack<>();
		for(int i=0;i<strs.length;i++) {
			List<String> cur_list = new ArrayList<>();
			cur_list.add(strs[i]);
			char[] arr = strs[i].toCharArray();
			Arrays.sort(arr);
			String s = new String(arr);
			if(!hm.containsKey(s)) {
				stk.push(s);
				hm.put(s, cur_list);
			}
			else {
				List<String> l = hm.get(s);
				l.addAll(cur_list);
				hm.put(s, l);
			}
		}
		while(!stk.isEmpty()) {
			ans.add(hm.get(stk.pop()));
		}
		return ans;        
    }
}
