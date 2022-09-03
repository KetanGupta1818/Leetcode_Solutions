class Solution {
    public long numberOfWeeks(int[] milestones) {
        long sum = 0L;
        long max = 0L;
        for(int milestone: milestones){
            sum += milestone;
            max = Math.max(max,milestone);
        }
        if(max<=sum-max) return sum;
        return 2*(sum-max)+1;
    }
}
