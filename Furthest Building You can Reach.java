class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        int sum = 0;
        for(int i=0;i<heights.length-1;i++){
            if(heights[i]>=heights[i+1]) continue;
            int dif = heights[i+1] - heights[i];
            if(minHeap.size()<ladders) minHeap.offer(dif);
            else if(minHeap.size() == 0) sum+=dif;
            else{
                if(dif<=minHeap.peek()) sum+=dif;
                else{
                    sum+=minHeap.remove();
                    minHeap.offer(dif);
                }
            }
            if(sum>bricks) return i;
        }
        return heights.length-1;
    }
}
