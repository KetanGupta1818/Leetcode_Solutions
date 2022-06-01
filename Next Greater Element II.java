class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[] answer = new int[nums.length];
        Arrays.fill(answer,Integer.MAX_VALUE);
        for(int num: nums) max = Math.max(max,num);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int values = 0;
        int n = nums.length;
        stack.push(0);
        for(int i=1;i<nums.length*2;i++){
            i = i%nums.length;
            int next = nums[i];
            while(!stack.isEmpty() && nums[stack.peek()] < next){
                int ii = stack.pop();
                if(answer[ii] == Integer.MAX_VALUE) values++;
                answer[ii] = next;
                
                if(values == n) return answer;
            } 
            if(next == max) {
                answer[i] = -1;
                values++;
            }
            else stack.push(i);
            if(values == n) return answer;
        }
        return answer;
    }
}
