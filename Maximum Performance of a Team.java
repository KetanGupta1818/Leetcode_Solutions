class Solution {
    private static final int MOD = 1_000_000_007;
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        long[][] matrix = new long[n][3];
        for(int i=0;i<n;i++){
            matrix[i][0] = efficiency[i];
            matrix[i][1] = speed[i];
        }
        Arrays.sort(matrix,(m1,m2)->(int)(m1[0]-m2[0]));
        Queue<Long> minHeap = new PriorityQueue<>();
        long maxSum = 0;
        for(int i=n-1;i>n-k;i--){
            maxSum += matrix[i][1];
            minHeap.offer(matrix[i][1]);
            matrix[i][2] = maxSum;
        }
        for(int i=n-k;i>=0;i--){
            matrix[i][2] = maxSum+matrix[i][1];
            if(!minHeap.isEmpty() && matrix[i][1]>minHeap.peek()){
                maxSum -= minHeap.remove();
                maxSum += matrix[i][1];
                minHeap.offer(matrix[i][1]);
            }
        }
        long max = 0L;
        for(int i=0;i<n;i++) max = Math.max(max,matrix[i][0]*matrix[i][2]);
        return (int)(max%MOD);
    }
}
