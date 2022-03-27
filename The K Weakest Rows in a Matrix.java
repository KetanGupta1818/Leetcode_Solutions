class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] answer = new int[k];
        Queue<int[]> queue = new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        for(int i=0;i<mat.length;i++){
            int[] r = mat[i];
            queue.offer(new int[]{Arrays.stream(r).sum(),i});
        }
        for(int i=0;i<k;i++) answer[i] = queue.poll()[1];
        return answer;
    }
}
