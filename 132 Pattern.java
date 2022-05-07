class Solution {
    public boolean find132pattern(int[] nums) {
        int t3 = Integer.MIN_VALUE;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<t3) return true;
            while(!stack.isEmpty() && nums[i]>stack.peek()) t3 = stack.pop();
            stack.push(nums[i]);
        }
        return false;
    }
}
