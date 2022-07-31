class Solution {
    private static boolean[] visited = new boolean[101];
    public int minimumOperations(int[] nums) {
        for(int i: nums) visited[i] = true;
        visited[0] = false;
        int counter = 0;
        for(int i=0;i<101;i++){
            if(visited[i]){
                counter++;
                visited[i] = false;
            }
        }
        return counter;
    }
}
