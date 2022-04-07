class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        for(int stone: stones) maxHeap.offer(stone);
        while(maxHeap.size()>1){
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if(x!=y) maxHeap.offer(y-x);
        }
        return maxHeap.size()!=0?maxHeap.poll():0;
    }
}
