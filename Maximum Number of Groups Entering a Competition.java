class Solution {
    private static List<Integer> list = new ArrayList<>();
    static {
        int n = 1;
        while((n*(n+1)/2)<=100_000){
            list.add((n*(n+1)/2));
            n++;
        }
    }
    public int maximumGroups(int[] grades) {
        int lo=0,hi=list.size()-1;
        while(lo<=hi){
            int m = (lo+hi)>>1;
            if(list.get(m) == grades.length) return m+1;
            else if(list.get(m)>grades.length) hi=m-1;
            else lo=m+1;
        }
        return hi+1;
    }
}
