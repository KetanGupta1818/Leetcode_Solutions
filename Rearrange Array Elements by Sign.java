class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Queue<Integer> negativeQueue = new ArrayDeque<>();
        Queue<Integer> positiveQueue = new ArrayDeque<>();
        for(int i: nums){
            if(i>0) positiveQueue.offer(i);
            else negativeQueue.offer(i);
        }
        for(int i=0;i<n;i++){
            if(i%2==0) ans[i]=positiveQueue.poll();
            else ans[i]=negativeQueue.poll();
        }
        return ans;
    }
}
