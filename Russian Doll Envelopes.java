public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(e1,e2)->e1[0]-e2[0]==0?e2[1]-e1[1]:e1[0]-e2[0]);
        List<Integer> list = new ArrayList<>();
        list.add(envelopes[0][1]);
        for(int[] e: envelopes){
            int height = e[1];
            if(height>list.get(list.size()-1)) list.add(height);
            else list.set(bs(list,height),height);
        }
        return list.size();
    }
    private int bs(List<Integer> list, int target){
        int lo=0,hi=list.size()-1;
        while(lo<=hi){
            int m = (lo+hi)/2;
            if(list.get(m) == target) return m;
            else if(list.get(m) > target) hi=m-1;
            else lo=m+1;
        }
        return lo;
    }
}
