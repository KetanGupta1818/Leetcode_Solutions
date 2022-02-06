class Solution {
   public long minimumDifference(int[] nums) {
        int n = nums.length/3;
        long[] minimumSums = new long[n+1];
        long[] maximumSums = new long[n+1];
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long minimumSum = 0;
        for(int i=0;i<n;i++){
            maxHeap.offer(nums[i]);
            minimumSum+=nums[i];
        }
        int index=0;
        minimumSums[index++] = minimumSum;
        for(int i=n;i<2*n;i++){
            if(nums[i]<maxHeap.peek()) {
                int removedNumber = maxHeap.poll();
                minimumSum = minimumSum+ nums[i] - removedNumber;
                maxHeap.offer(nums[i]);
            }
            minimumSums[index++] = minimumSum;
        }
        long maximumSum = 0;
        for(int i=3*n-1;i>=2*n;i--){
            maximumSum+=nums[i];
            minHeap.offer(nums[i]);
        }
        index=0;
        maximumSums[index++] = maximumSum;
        for(int i=2*n-1;i>=n;i--){
            if(nums[i]>minHeap.peek()){
                int removedNumber = minHeap.poll();
                maximumSum = maximumSum+ nums[i] - removedNumber;
                minHeap.offer(nums[i]);
            }
            maximumSums[index++] = maximumSum;
        }
        for(int i=0;i<maximumSums.length/2;i++){
            long temp = maximumSums[i];
            maximumSums[i] = maximumSums[n-i];
            maximumSums[n-i] = temp;
        }
        long min = Long.MAX_VALUE;
        for(int i=0;i<n+1;i++){
            min = Math.min(min,minimumSums[i]-maximumSums[i]);
        }
        return min;
     }
}
