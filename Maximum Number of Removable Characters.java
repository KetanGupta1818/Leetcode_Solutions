class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int lo=0,hi=removable.length-1;
        while(lo<=hi){
            int m = (lo+hi)/2;
            if(isSubs(s,p,removable,m)) lo=m+1;
            else hi=m-1;
        }
        return hi+1;
    }
    private boolean isSubs(String s, String p, int[] removable, int end){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<=end;i++) set.add(removable[i]);
        int j = 0;
        for(int i=0;i<s.length();i++){
            if(set.contains(i)) continue;
            if(j == p.length()) return true;
            if(s.charAt(i) == p.charAt(j)) j++;
        }
        return j == p.length();
    }
}
