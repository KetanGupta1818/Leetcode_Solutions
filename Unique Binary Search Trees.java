int numTrees(int n){
    if(n<=1) return 1;
    int sum = 0;
    for(int root=1;root<=n;root++) sum+=numTrees(root-1)*numTrees(n-root);
    return sum;
}
