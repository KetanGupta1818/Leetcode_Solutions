class Solution {
    private final static int[] fac = {1,1,2,6,24,120,720,5040,40320,362880};
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++) list.add(i);
        k--;
        StringBuilder answer = new StringBuilder();
        for(int i=n-1;i>=0;i--) {
            int pos = k/fac[i];
            k = k%fac[i];
            answer.append(list.remove(pos));
        }
        return answer.toString();
    }
}
