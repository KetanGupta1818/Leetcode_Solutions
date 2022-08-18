class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] answer = new int[n-k+1];
        TreeMap<Integer,Integer> map = new TreeMap<>(Collections.reverseOrder());
        for(int i=0;i<k-1;i++) map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        for(int left=0;left<n-k+1;left++){
            map.put(nums[left+k-1],map.getOrDefault(nums[left+k-1],0)+1);
            answer[left] = map.firstKey();
            map.put(nums[left],map.get(nums[left])-1);
            if(map.get(nums[left]) == 0) map.remove(nums[left]);
        }
        return answer;
    }
}
