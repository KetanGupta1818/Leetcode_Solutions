class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int[] edge: edges){
            graph.get(edge[0]-1).add(edge[1]-1);
            graph.get(edge[1]-1).add(edge[0]-1);
        }
        Map<Integer,Integer> cache = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[]{0,0});
        while(!queue.isEmpty()){
            int[] top = queue.poll();
            int vertex = top[0];
            int timeElapsed = top[1];
            if(vertex == n-1 && timeElapsed>cache.getOrDefault(vertex,Integer.MAX_VALUE)) return timeElapsed;
            if(!cache.containsKey(vertex)) cache.put(vertex,timeElapsed);
            else if(cache.get(vertex) == timeElapsed || visited.contains(vertex)) continue;
            else visited.add(vertex);
            int factor = timeElapsed/change;
            if(factor%2 == 1) timeElapsed = (factor+1)*change;
            for(int child: graph.get(vertex)){
                if(!visited.contains(child)) queue.offer(new int[]{child,time+timeElapsed});
            }
        }
        return -101;
    }
}
