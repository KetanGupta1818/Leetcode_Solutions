class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] answer = new int[nums.length];
        List<Queue<Integer>> map = new ArrayList<>();
        for(int i=0;i<32;i++) map.add(new PriorityQueue<>());
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            int index = 0;
            while(num>0){
                if((num&1)==1){
                    map.get(index).add(i);
                }
                index++;
                num=num>>1;
            }
        }
        for(int i=0;i<n;i++){
            int max = i;
            for(int j=0;j<32;j++){
                Queue<Integer> queue = map.get(j);
                if(queue.isEmpty()) continue;
                max = Math.max(queue.peek(),max);
                if(queue.peek() == i) queue.remove();
            }
            answer[i] = max-i+1;
        }
        return answer;
    }
}
