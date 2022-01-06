class Solution {
    HashMap<String, Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return wb(s, set);
    }
    private boolean wb(String s, Set<String> set) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        if(map.containsKey(s)) return map.get(s);
        for (int i = 1; i <= len; ++i) {
            if (set.contains(s.substring(0, i)) && wb(s.substring(i), set)) {
                map.put(s,true);
                return true;
            }
        }
        map.put(s,false);
        return false;
    }
}
