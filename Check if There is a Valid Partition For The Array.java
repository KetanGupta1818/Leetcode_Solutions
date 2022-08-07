class Solution {
    public boolean validPartition(int[] arr) {
        return fun(new int[arr.length],0,arr)==1;
    }
    private int fun(int[] dp, int index, int[] arr){
        int res = -1;
        if(index == arr.length) return 1;
        if(index == arr.length-1) return -1;
        if(dp[index]!=0) return dp[index];
        if(arr[index]==arr[index+1]) res = Math.max(res, fun(dp,index+2,arr));
        if(index == arr.length-2) return dp[index] = res;
        if(arr[index]==arr[index+1] && arr[index+1]==arr[index+2]) res = Math.max(res, fun(dp,index+3,arr));
        if(arr[index+1]-arr[index]== 1  && arr[index+2]-arr[index+1]==1) res = Math.max(res, fun(dp,index+3,arr));
        return dp[index] = res;
    }
}
