class Solution {
    boolean[] visited;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        visited = new boolean[graph.length];
        List<List<Integer>> answer = new ArrayList<>();
        dfs(0,graph,answer,new ArrayList<>());
        return answer;
    }
    public void dfs(int source, int[][] graph, List<List<Integer>> answer,
                   List<Integer> currentList){
        if(source == graph.length-1){
            currentList.add(source);
            answer.add(new ArrayList<Integer>(currentList));
            return;
        }
        currentList.add(source);
        visited[source] = true;
        for(int adjacentNode: graph[source]){
            if(!visited[adjacentNode]){
                dfs(adjacentNode, graph, answer, currentList);
                visited[adjacentNode] = false;
                currentList.remove(currentList.size()-1);
            }
        }
    }
}
