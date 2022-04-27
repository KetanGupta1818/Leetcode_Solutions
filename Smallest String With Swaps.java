class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        Union un = new Union(s.length());
        pairs.forEach(pair -> un.union(pair.get(0),pair.get(1)));
        return un.fun(s);
    }
}
class Union{
    int[] rank;
    int[] root;
    int n;
    public Union(int n){
        rank = new int[n];
        root = new int[n];
        for(int i=0;i<n;i++){
            rank[i] = 1;
            root[i] = i;
        }
        this.n = n;
    }
    
    public int find(int v){
        if(v == root[v]) return v;
        return root[v] = find(root[v]);
    }
    
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY) return;
        if(rank[rootX]>rank[rootY]) root[rootY] = rootX;
        else if(rank[rootY]>rank[rootX]) root[rootX] = rootY;
        else {
            root[rootX] = rootY;
            rank[rootY]++;
        }
    }
    public String fun(String s){
        StringBuilder sb = new StringBuilder();
        Map<Integer,Queue<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            Queue<Integer> queue;
            int root = find(i);
            if(map.containsKey(root)) queue = map.get(root);
            else queue = new PriorityQueue<>();
            queue.offer((int)s.charAt(i));
            map.put(root,queue);
        }
        for(int i=0;i<n;i++) {
            Queue<Integer> queue = map.get(find(i));
            sb.append((char)(int)queue.poll());
            map.put(find(i),queue);
        }
        return sb.toString();
    }
}
