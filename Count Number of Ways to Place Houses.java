class Solution {
    public int countHousePlacements(int n) {
        long total=0,house=2,space=3;
        if(n==1) return 2*2;
        if(n==2) return 3*3;
        for(int i=3;i<=n;i++){
            total = (house+space)%1_000_000_007;
            house = space;
            space = total;
        }
        return (int)((total*total)%1_000_000_007);
    }
}
