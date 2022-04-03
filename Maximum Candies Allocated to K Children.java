class Solution {
    public int maximumCandies(int[] candies, long k) {
        int lo=0,hi=10000000;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(numberOfPiles(candies,mid)>=k) lo=mid+1;
            else hi=mid-1;
        }
        return Math.max(0,hi);
    }
    public long numberOfPiles(int[] candies, int n){
        long sum = 0L;
        for(int candy: candies) {
            if(n==0) sum+=candy;
            else sum+=candy/n;
        }
        return sum;
    }
}
