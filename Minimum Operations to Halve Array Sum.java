class Solution {
    public int halveArray(int[] nums) {
        Queue<Double> queue = new PriorityQueue<>(Collections.reverseOrder());
        double sum = 0;
        for(int num: nums) {
            sum+=(double) num;
            queue.offer((double)num);
        }
        double sumRemoved=0;
        double targetSum = sum/2;
        int numberOfOperations = 0;
        while(sumRemoved<targetSum){
            numberOfOperations++;
            double curNumber = queue.poll();
            curNumber/=2;
            sumRemoved+=curNumber;
            queue.offer(curNumber);
        }
        return numberOfOperations;
    }
}
