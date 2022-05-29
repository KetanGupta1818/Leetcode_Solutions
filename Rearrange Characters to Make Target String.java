class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long importance = 0l;
        int[] degrees = new int[n];
        for(int[] road: roads){
            degrees[road[0]]++;
            degrees[road[1]]++;
        }
        Arrays.sort(degrees);
        for(int i=0;i<n;i++) importance+= (long) (i + 1) * degrees[i];
        return importance;
    }
}
