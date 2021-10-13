class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> answer = new ArrayList<>();
        int[] indegree_arr = new int[n];
        for(int i=0;i<edges.size();i++) indegree_arr[edges.get(i).get(1)]++;
        for(int i=0;i<n;i++) if(indegree_arr[i]==0) answer.add(i);
        return answer;
    }
}

//If a node has a indegree it can be reached from some other node. So we just need to return the number of nodes whoes indegree is 0.
