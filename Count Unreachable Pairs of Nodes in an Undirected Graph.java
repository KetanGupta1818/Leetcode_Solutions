class Solution {
    public long countPairs(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] e: edges) uf.union(e[0],e[1]);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) map.put(uf.find(i),map.getOrDefault(uf.find(i),0)+1);
        long answer=0L,sum=0L;
        for(int key: map.keySet()) 
            answer += (long) (n - map.get(key)) * (long)map.get(key);
        return answer/2;
    }
}
class UnionFind {
    private int[] root;
    private int[] rank;
    private int count;

    UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        count = size;
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }
}
