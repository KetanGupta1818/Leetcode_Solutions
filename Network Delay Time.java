class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> edges = new ArrayList<>();
        int start = k-1;
        for(int i=0;i<n;i++) edges.add(new ArrayList<>());
        for(int[] time: times) edges.get(time[0]-1).add(new int[]{time[1]-1,time[2]});
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] shortestTime = new int[n];
        Arrays.fill(shortestTime,Integer.MAX_VALUE);
        shortestTime[start] = 0;
        queue.add(new int[]{start,shortestTime[start]});
        while(!queue.isEmpty()){
            int cur = queue.poll()[0];
            for(int[] edge: edges.get(cur)){
                if(shortestTime[edge[0]]>shortestTime[cur]+edge[1]){
                    shortestTime[edge[0]] = shortestTime[cur]+edge[1];
                    queue.offer(new int[]{edge[0],edge[1]});
                }
            }
        }
        int answer = Arrays.stream(shortestTime).max().getAsInt();
        return answer == Integer.MAX_VALUE?-1:answer;
    }
}
