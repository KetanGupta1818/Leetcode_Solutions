class Solution {
    public int partitionString(String S) {
        char[] s = S.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int ans = 1;
        for(char c: s){
            if(set.contains(c)){
                set = new HashSet<>();
                ans++;
            }
            set.add(c);
        }
        return ans;
    }
}
