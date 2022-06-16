class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int answer=0;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int i=0;i<n;i++) {
            if(manager[i] == -1) continue;
            graph.get(manager[i]).add(i);
        }
        return fun(headID,graph,informTime);
    }
    private int fun(int node, List<List<Integer>> graph, int[] informTime){
        int sum=informTime[node];
        int max = 0;
        for(int child: graph.get(node)) {
            max = Math.max(max,sum+fun(child,graph,informTime));
        }
        return max;
    }
}
