class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ways = 0L;
        int bigger = Math.max(cost1,cost2);
        int smaller = Math.min(cost1,cost2);
        int times=0;
        while(bigger*times<=total){
            ways += ((total- (long) bigger *times)/smaller)+1;
            times++;
        }
        return ways;
    }
}
