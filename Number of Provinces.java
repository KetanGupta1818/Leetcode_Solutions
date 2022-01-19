class Solution {
    int[] root;
    int[] rank;
    
    private void solution(int size){
        root = new int[size+1];
        rank = new int[size+1];
        for(int i=0;i<=size;i++){
            rank[i] = 1;
            root[i] = i;
        }
        root[0] = -1;
        rank[0] = -1;
    }
    public int findCircleNum(int[][] isConnected) {
        //Quick union with recursive find and ranked union 
        int n = isConnected.length;
        solution(n);
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isConnected[i][j] == 1){
                    union(i+1,j+1);
                }
            }
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int i=1;i<=n;i++) set.add(find(root[i]));
        return set.size();
    }
    public void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA!=rootB){
            if(rank[rootA]>rank[rootB]) root[rootB]=rootA;
            else if(rank[rootB]>rank[rootA]) root[rootA]=rootB;
            else{
                root[rootA] = rootB;
                rank[rootB]+=1;
            }
        }
    }
    public int find(int x){
        if(x==root[x]) return x;
        return root[x] = find(root[x]);
    }
}
