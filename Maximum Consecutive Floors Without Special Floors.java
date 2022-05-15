class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int max = special[0] - bottom;
        int  n = special.length;
        max = Math.max(max,top - special[n-1]);
        for(int i=1;i<n;i++) max = Math.max(max,special[i]-special[i-1]-1);
        return max;
    }
}
