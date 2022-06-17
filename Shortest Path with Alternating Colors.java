class Solution {
    //Red Color = 1    && Blue Color = 0;
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[][] shortestDistance = new int[n][2];
        for(int i=0;i<n;i++) Arrays.fill(shortestDistance[i],Integer.MAX_VALUE);
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int[] redEdge: redEdges) graph.get(redEdge[0]).add(new int[]{redEdge[1],1});
        for(int[] blueEdge: blueEdges) graph.get(blueEdge[0]).add(new int[]{blueEdge[1],0});
        shortestDistance[0][0] = 0;
        shortestDistance[0][1] = 0;
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));  //[vertex,weight,edge_color_by_which_its_reached]
        queue.offer(new int[]{0,shortestDistance[0][0],0});     
        queue.offer(new int[]{0,shortestDistance[0][1],1});
        while(!queue.isEmpty()){
            int[] cur = queue.remove();
            int vertex = cur[0];
            int parent_color = cur[2];
            for(int[] childEdge: graph.get(vertex)){
                int child = childEdge[0];
                int child_color = childEdge[1];
                if(parent_color!=child_color){
                    if(shortestDistance[child][child_color]>=shortestDistance[vertex][parent_color]+1){
                        shortestDistance[child][child_color]=shortestDistance[vertex][parent_color]+1;
                        queue.offer(new int[]{child,shortestDistance[child][child_color],child_color});
                    }
                }
            }
        }
        int[] answer = new int[n];
        for(int i=0;i<n;i++){
            int min = Math.min(shortestDistance[i][0],shortestDistance[i][1]);
            if(min == Integer.MAX_VALUE) answer[i] = -1;
            else answer[i] = min;
        }
        return answer;
    }
}
