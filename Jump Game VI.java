class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Queue<int[]> queue = new PriorityQueue<>((a,b)->b[0]-a[0]);
        int[] dp = new int[n];
        dp[0] = nums[0];
        queue.offer(new int[]{dp[0],0});
        for(int i=1;i<=k;i++){
            if(i == n) break;
            dp[i] = nums[i] + queue.peek()[0];
            queue.offer(new int[]{dp[i],i});
        }
        for(int left=1,right=k+1;right<n;right++){
            while(queue.peek()[1] < left) queue.remove();
            left++;
            dp[right] = queue.peek()[0]+nums[right];
            queue.offer(new int[]{dp[right],right});
        }
        return dp[n-1];
    }
}
