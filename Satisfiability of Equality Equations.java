class Solution {

    public boolean equationsPossible(String[] equations) {
        UnionFind equalsSet = new UnionFind(26);
        HashSet<Pair> unequalsSet = new HashSet<>();
        boolean[] isVariable = new boolean[26];
        for(String equation: equations){
            int v1 = equation.charAt(0)-'a';
            int v2 = equation.charAt(3)-'a';
            isVariable[v1] = true;
            isVariable[v2] = true;
            boolean equals = equation.charAt(1)=='=';
            if(v1==v2 && !equals) return false;
            if(equals) equalsSet.union(v1,v2);
            else {
                unequalsSet.add(new Pair(v1,v2));
                unequalsSet.add(new Pair(v2,v1));
            }
        }
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<26;i++){
            if(isVariable[i]){
                int root = equalsSet.find(i);
                List<Integer> list = map.getOrDefault(root,new ArrayList<>());
                list.add(i);
                map.put(root,list);
            }
        }
        
        for(int root: map.keySet()){
            List<Integer> equalsGroup = map.get(root);
            for(int i=0;i<equalsGroup.size()-1;i++){
                for(int j=i+1;j<equalsGroup.size();j++){
                    if(unequalsSet.contains(new Pair(equalsGroup.get(i),equalsGroup.get(j)))) return false;
                }
            }
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
}
class Pair{
    int u;
    int v;

    public Pair(int u, int v) {
        this.u = u;
        this.v = v;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair pair = (Pair) o;
        return u == pair.u && v == pair.v;
    }

    @Override
    public int hashCode() {
        return u+v*31;
    }
}
