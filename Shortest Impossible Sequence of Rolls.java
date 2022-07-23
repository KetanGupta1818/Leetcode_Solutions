class Solution {
    public int shortestSequence(int[] rolls, int k) {
        int ans = 1;
        Set<Integer> set = new HashSet<>();
        for(int r: rolls){
            set.add(r);
            if(set.size() == k){
                ans++;
                set.clear();
            }
        }
        return ans;
    }
}
