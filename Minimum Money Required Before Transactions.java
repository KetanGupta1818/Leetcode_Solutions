class Solution {
    public long minimumMoney(int[][] transactions) {
        Queue<int[]> maxHeap = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int maxValueProfit = 0;
        for(int[] transaction: transactions){
            int cost = transaction[0];
            int cashBack = transaction[1];
            if(cost>cashBack) maxHeap.offer(new int[]{cost,cashBack});
            else maxValueProfit = Math.max(maxValueProfit,cost);
        }
        long answer = 0L, cur_money = 0L;
        while(!maxHeap.isEmpty()){
            int[] transaction = maxHeap.remove();
            int cost = transaction[0];
            int cashBack = transaction[1];
            if(cur_money<cost){
                answer += cost-cur_money;
                cur_money = cost;
            }
            cur_money -= cost;
            cur_money += cashBack;
        }
        if(cur_money<maxValueProfit) answer += (maxValueProfit-cur_money);
        return answer;
    }
}
