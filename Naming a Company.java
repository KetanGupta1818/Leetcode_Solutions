class Solution {
    public long distinctNames(String[] ideas) {
        List<HashSet<Integer>> map = new ArrayList<>();
        for(int i=0;i<26;i++) map.add(new HashSet<>());
        for(String idea: ideas){
            char c = idea.charAt(0);
            map.get(c-'a').add(idea.substring(1).hashCode());
        }
        
        long res = 0L;
        for(int i=0;i<26;i++){
            for(int j=i+1;j<26;j++){
                int c1=0,c2=0;
                for(int c: map.get(i)) if(!map.get(j).contains(c)) c1++;
                for(int c: map.get(j)) if(!map.get(i).contains(c)) c2++;
                res += (long) c1 *c2;
            }
        }
        return res*2;
    }
}
