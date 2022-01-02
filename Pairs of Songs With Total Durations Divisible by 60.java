class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] arr = new int[60];
        for(int t: time) arr[t%60]++;
        int sum = 0;
        for(int i=1;i<30;i++){
            sum = sum + arr[i]*arr[60-i];
        }
        sum = sum + combinator(arr[0]) + combinator(arr[30]);
        return sum;
    }
    public int combinator(int val){
        return  (val*(val-1))/2;
    }
}
