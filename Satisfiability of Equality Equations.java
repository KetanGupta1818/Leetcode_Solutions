class Solution {

    public boolean equationsPossible(String[] equations) {
        UnionFind equalsSet = new UnionFind(26);
        List<Pair> unequalsList = new ArrayList<>();
        for(String equation: equations){
            int v1 = equation.charAt(0)-'a';
            int v2 = equation.charAt(3)-'a';
            boolean equals = equation.charAt(1)=='=';
            if(v1==v2 && !equals) return false;
            if(equals) equalsSet.union(v1,v2);
            else unequalsList.add(new Pair(v1,v2));
        }
        for(Pair pair: unequalsList) if(equalsSet.isConnected(pair.u, pair.v)) return false;
        return true;
    }

}
class UnionFind{
    int[] rank;
    int[] root;

    public UnionFind(int n){
        this.root = new int[n];
        this.rank = new int[n];

        for(int i=0;i<n;i++){
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int v){
        if(v == root[v]) return v;
        return root[v] = find(root[v]);
    }

    public boolean isConnected(int x, int y){
        return find(x) == find(y);
    }

    public boolean union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY) return false;
        if(rank[rootX] > rank[rootY]) root[rootY] = rootX;
        else if(rank[rootY] > rank[rootX]) root[rootX] = rootY;
        else{
            rank[rootX]++;
            root[rootY] = rootX;
        }
        return true;
    }
    public boolean onlyOneRoot(){
        int root1 = find(0);
        for(int i=1;i<root.length;i++) if(root1!=find(i)) return false;
        return true;
    }
}
class Pair{
    int u;
    int v;

    public Pair(int u, int v) {
        this.u = u;
        this.v = v;
    }
}
