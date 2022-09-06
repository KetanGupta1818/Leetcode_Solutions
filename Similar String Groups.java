class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        UnionFind unionFind = new UnionFind(n);
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(differByOne(strs[i],strs[j])) unionFind.union(i,j);
            }
        }
        return unionFind.numberOfRoots();
    }
    private boolean differByOne(String s1,String s2){
        int dif = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)) dif++;
            if(dif>2) return false;
        }
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
    public int numberOfRoots(){
        boolean[] isRoot = new boolean[root.length];
        for(int i=0;i<root.length;i++) isRoot[find(i)] = true;
        int cnt=0;
        for(boolean res: isRoot) if(res) cnt++;
        return cnt;
    }
}
