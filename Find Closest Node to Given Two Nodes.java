class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] one = bfs(edges,node1);
        int[] two = bfs(edges,node2);
        int min = Integer.MAX_VALUE, index=-1;
        for(int i=0;i<edges.length;i++){
            if(one[i]==-1 || two[i]==-1) continue;
            if(min>Math.max(one[i],two[i])){
                min = Math.max(one[i],two[i]);
                index = i;
            }
        }
        return index;
    }
    private int[] bfs(int[] edges, int node){
        boolean[] visited = new boolean[edges.length];
        visited[node] = true;
        int[] distances = new int[edges.length];
        Arrays.fill(distances,-1);
        distances[node] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            int cur = queue.remove();
            if(edges[cur] == -1) continue;
            int child = edges[cur];
            if(visited[child]) continue;
            visited[child] = true;
            distances[child] = distances[cur]+1;
            queue.offer(child);
        }
        return distances;
    }
}
