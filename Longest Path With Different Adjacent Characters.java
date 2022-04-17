class Solution {
    int res = 0;
    public int longestPath(int[] parent, String s) {
        List<List<Integer>> tree = new ArrayList<>();
        int n = parent.length;
        for(int i=0;i<n;i++) tree.add(new ArrayList<>());
        for(int i=1;i<n;i++) tree.get(parent[i]).add(i);
        dfs(0,tree,s);
        return res;
    }
    private int dfs(int cur, List<List<Integer>> tree, String s){
        Queue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        for(int child: tree.get(cur)){
            if(s.charAt(child)!=s.charAt(cur)){
                queue.offer(dfs(child,tree,s));
            }
            else dfs(child,tree,s);
        }
        int big1 = queue.isEmpty() ? 0 : queue.poll();
        int big2 = queue.isEmpty() ? 0 : queue.poll();
        res = Math.max(res,big1+big2+1);
        return big1+1;
    }
}
