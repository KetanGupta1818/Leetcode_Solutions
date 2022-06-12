class Solution {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        Map<Character,HashSet<Character>> map = new HashMap<>();
        for(char[] mapping: mappings) {
            HashSet<Character> set = map.getOrDefault(mapping[0],new HashSet<>());
            set.add(mapping[1]);
            map.put(mapping[0],set);
        }
        pro: for(int i=0;i<=s.length()-sub.length();i++){
            char c = s.charAt(i);
            if(c!=sub.charAt(0) && !map.getOrDefault(sub.charAt(0),new HashSet<>()).contains(c)) continue;
            String checkString = s.substring(i,i+sub.length());
            for(int j=0;j<checkString.length();j++){
                if(checkString.charAt(j)!=sub.charAt(j) && !map.getOrDefault(sub.charAt(j),new HashSet<>()).contains(checkString.charAt(j))) continue pro;
            }
            return true;
        }
        return false;
    }
}
