class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int n = arr.length;
        long ways = 0;
        int mod = 1_000_000_007;
        for(int i=0;i<n-2;i++){
            int[] count = new int[101];
            for(int j=i+1;j<n;j++){
                int k = target - arr[i] - arr[j];
                if(k>=0 && k<=100 && count[k]>0){
                    ways+=count[k];
                    ways%=mod;
                }
                count[arr[j]]++;
            }
        }
        return (int)ways;
    }

}
