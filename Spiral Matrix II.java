class Solution {
    public int[][] generateMatrix(int n) {
        int k,num=0;
        int[][] arr = new int[n][n];
        for(int i=0;i<n/2;i++){
            for(k=0;k<n-2*i;k++) arr[i][k+i] = ++num;
            for(k=0;k<n-2*i-1;k++) arr[k+1+i][n-1-i] = ++num;
            for(k=n-2-i;k>=i;k--) arr[n-1-i][k] = ++num;
            for(k=n-2-i;k>i;k--) arr[k][i] = ++num;
        }
        if(n%2==1) arr[n/2][n/2] = ++num;
        return arr;
    }
}
