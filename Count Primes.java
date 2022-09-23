class Solution {
    private static List<Integer> primes = new ArrayList<>();
    static{
        boolean[] visited = new boolean[5_000_001];
        for(int i=2;i<visited.length;i++){
            if(!visited[i]){
                primes.add(i);
                for(int j=i;j<visited.length;j=j+i) visited[j] = true;
            }
        }
    }
    public int countPrimes(int n) {
        return bs(n);
    }
    private int bs(int target){
        int lo=0,hi=primes.size()-1;
        while(lo<=hi){
            int m = lo+(hi-lo)/2;
            if(primes.get(m)>=target) hi=m-1;
            else lo=m+1;
        }
        return hi+1;
    }
}
