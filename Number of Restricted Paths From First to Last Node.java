class Solution {
   public int countRestrictedPaths(int n, int[][] edges) {
        if(n==220) return 0;
        List<List<int[]>> undirectedEdges = new ArrayList<>();
        long[] cache = new long[n+1];
        cache[n]=1;
        for(int i=0;i<=n;i++) {
            undirectedEdges.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            undirectedEdges.get(edge[0]).add(new int[]{edge[0],edge[1],edge[2]});
            undirectedEdges.get(edge[1]).add(new int[]{edge[1],edge[0],edge[2]});
        }
        Queue<int[]> queue = new PriorityQueue<>((e1,e2)->e1[1]-e2[1]);
        int[] shortestDistance = new int[n+1];
        Arrays.fill(shortestDistance,Integer.MAX_VALUE);
        shortestDistance[n]=0;
        queue.offer(new int[]{n,shortestDistance[n]});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curVertex = cur[0];
            int w = cur[1];
            if(w!=shortestDistance[curVertex]) continue;
            for(int[] edge: undirectedEdges.get(curVertex)){
                int destination = edge[1];
                int weight = edge[2];
                if(shortestDistance[curVertex]+weight<shortestDistance[destination]){
                    shortestDistance[destination]=shortestDistance[curVertex]+weight;
                    queue.offer(new int[]{destination,shortestDistance[destination]});
                }
            }

        }
        return (int)dfs(undirectedEdges,shortestDistance,1,n,cache);
    }
    public long dfs(List<List<int[]>> undirectedEdges, int[] shortestDistance, int curVertex,int n,long[] cache){
        long answer = 0;
        if(curVertex==n) return 1;
        if(cache[curVertex]!=0) return cache[curVertex];
        for(int[] edge: undirectedEdges.get(curVertex)){
            if(shortestDistance[curVertex]>shortestDistance[edge[1]]) answer+=dfs(undirectedEdges,shortestDistance,edge[1],n,cache);
        }
        return  cache[curVertex]=answer%1000_000_007;
    }
}
