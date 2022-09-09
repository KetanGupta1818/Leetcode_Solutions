class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties,(p1,p2)->{
            if(p2[0] == p1[0]) return p1[1]-p2[1];
            return p2[0]-p1[0];
        });
        int md=0,ans=0;
        for(int[] prop: properties){
            if(prop[1]<md) ans++;
            md=Math.max(md,prop[1]);
        }
        return ans;
    }
}
