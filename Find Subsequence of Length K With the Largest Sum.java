class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] answer = new int[k];
        int index = 0;
        Queue<Pair> queue = new PriorityQueue<>((p1,p2)->p2.element-p1.element);
        for(int i=0;i<nums.length;i++) queue.offer(new Pair(nums[i],i));
        List<Pair> list = new ArrayList<>();
        for(int i=0;i<k;i++) list.add(queue.remove());
        list.sort((p1,p2)-> p1.index-p2.index);
        for(Pair p: list) answer[index++] = p.element;
        return answer;
    }
}
class Pair{
    int element;
    int index;

    public Pair(int element, int index) {
        this.element = element;
        this.index = index;
    }
}
