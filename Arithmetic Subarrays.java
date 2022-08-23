class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList<>();
        b: for(int i=0;i<l.length;i++){
            int left = l[i];
            int right = r[i];
            if(left == right) {
                list.add(false);
                continue;
            }
            Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
            for(int j=left;j<=right;j++) queue.offer(nums[j]);
            int dif = queue.remove() - queue.peek();
            while(queue.size()!=1){
                if(queue.remove() - queue.peek() != dif) {
                    list.add(false);
                    continue b;
                }
            }
            list.add(true);
        }
        return list;
    }
}
