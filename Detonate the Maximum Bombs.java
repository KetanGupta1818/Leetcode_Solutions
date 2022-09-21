class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        Circle[] circles = new Circle[n];
        for(int i=0;i<n;i++) circles[i] = new Circle(bombs[i][0],bombs[i][1],bombs[i][2]);
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(circles[i].canDetonate(circles[j]))
                    graph.get(i).add(j);
            }
        }
        int answer = 0;
        for(int i=0;i<n;i++) answer = Math.max(answer,dfs(graph,new boolean[n],i));
        return answer;
    }
    private int dfs(List<List<Integer>> graph, boolean[] visited, int node){
        int res = 1;
        visited[node] = true;
        for(int child: graph.get(node)){
            if(visited[child]) continue;
            res += dfs(graph,visited,child);
        }
        return res;
    }
}
class Circle{
    int x;
    int y;
    int r;

    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
    public boolean canDetonate(Circle other){
        return this.r>=Math.sqrt(Math.pow(Math.abs(this.x-other.x),2)+Math.pow(Math.abs(this.y-other.y),2));
    }
    
}
