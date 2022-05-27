class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int[] edge: edges){
            graph.get(edge[0]).add(new int[]{edge[1],edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }
        int answerIndex = -1;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int val = dijkstra(n,i,graph,distanceThreshold);
            if(val<=min) {
                min = val;
                // System.out.println(val);
                answerIndex = i;
            }
        }
        return answerIndex;
    }
    private int dijkstra(int n, int start, List<List<int[]>> graph, int distanceThreshold){
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[]{start,0});
        int[] shortestDistance = new int[n];
        Arrays.fill(shortestDistance,Integer.MAX_VALUE);
        shortestDistance[start] = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cur_vertex = cur[0];
            for(int[] e: graph.get(cur_vertex)){
                int next_vertex = e[0];
                if(shortestDistance[next_vertex]>shortestDistance[cur_vertex]+e[1]){
                    shortestDistance[next_vertex] = shortestDistance[cur_vertex]+e[1];
                    queue.offer(new int[]{next_vertex,shortestDistance[next_vertex]});
                }
                
            }
        }
        // System.out.println(Arrays.toString(shortestDistance));
        return numberOfElementsAtMostThreshold(shortestDistance,distanceThreshold);
    }
    private int numberOfElementsAtMostThreshold(int[] arr, int threshold){
        int freq = 0;
        for(int a: arr) if(a<=threshold) freq++;
        return freq-1;
    }
}
