class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<capacity.length;i++) queue.offer(capacity[i]-rocks[i]);
        int rf = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(cur>additionalRocks) break;
            rf++;
            additionalRocks-=cur;
        }
        return rf;
    }
}
