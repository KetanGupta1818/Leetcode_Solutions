class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if(n==1) return 0;
        int allMask = (1 << n) - 1;
        boolean[][] seen = new boolean[n][allMask];
        ArrayList<int[]> queue = new ArrayList<>();
        for(int i=0;i<n;i++){
            queue.add(new int[]{i,1<<i});
            seen[i][1<<i] = true;
        }
        int steps=0;
        while(!queue.isEmpty()){
            ArrayList<int[]> nextQueue = new ArrayList<>();
            for(int i=0;i<queue.size();i++){
                int[] currentState = queue.get(i);
                int curNode = currentState[0];
                int mask = currentState[1];
                for(int neighbour: graph[curNode]){
                    int nextMask = mask | (1<<neighbour);
                    if(nextMask==allMask) return 1+steps;
                    if(!seen[neighbour][nextMask]){
                        seen[neighbour][nextMask] = true;
                        nextQueue.add(new int[]{neighbour,nextMask});
                    }
                }
            }
            steps++;
            queue=nextQueue;
        }
        return 8888;
    }
}
