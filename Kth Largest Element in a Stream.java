class KthLargest {
    int k;
    Queue<Integer> minHeap;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<Integer>();
        for(int i: nums) minHeap.offer(i);
        while(minHeap.size()>k) minHeap.poll();
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size()>k) minHeap.poll();
        return minHeap.peek();
    }
}
