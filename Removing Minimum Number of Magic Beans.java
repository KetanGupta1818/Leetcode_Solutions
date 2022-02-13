class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);long sum=0;
        long answer = Long.MAX_VALUE;
        for(int i=0;i<beans.length;i++) sum+=beans[i];
        long n = beans.length;
        for(int i=0;i<beans.length;i++) answer = Math.min(answer,sum-(n-i)*(long)beans[i]);
        return answer;
    }
}
