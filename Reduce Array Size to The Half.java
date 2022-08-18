class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int a: arr) map.put(a,map.getOrDefault(a,0)+1);
        Queue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        for(int key: map.keySet()) queue.offer(map.get(key));
        int sum=0,rep=0;
        while(!queue.isEmpty()){
            sum += queue.remove();
            rep++;
            if(sum>=arr.length/2) return rep;
        }
        return -1;
    }
}
