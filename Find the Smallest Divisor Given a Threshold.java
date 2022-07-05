class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo=1,hi=1000000;
        while(lo<=hi){
            int m = lo+(hi-lo)/2;
            if(threshold<res(nums,m)) lo=m+1;
            else hi=m-1;
        }
        return lo;
    }
    private int res(int[] nums, int k){
        int sum = 0;
        for(int i: nums) sum += i/k + ((i%k==0)?0:1);
        return sum;
    }
}
