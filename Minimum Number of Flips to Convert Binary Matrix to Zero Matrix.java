class Solution {
    public int minFlips(int[][] mat) {
        int[] d = {0,1,0,-1,0};
        int start=0, steps=0, m=mat.length, n=mat[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                start |= mat[i][j]<<(i*n+j);
            }
        }
        //System.out.println(Integer.toBinaryString(start));
        if(start==0) return steps;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        visited.add(start);
        queue.offer(start);
        while(!queue.isEmpty()){
            for(int s=queue.size();s>0;s--){
                int cur = queue.poll();
                for(int i=0;i<m;i++){
                    for(int j=0;j<n;j++){
                        int next = cur;
                        next ^= 1<<(i*n)+j; //Flip current bit
                        for(int k=0;k<4;k++){
                            int r = i+d[k], c=j+d[k+1];
                            if(r>m-1||c>n-1||c<0||r<0) continue;
                            next ^= 1<<(r*n)+c;

                        }
                        if(next==0) return steps+1;
                        if(!visited.contains(next)){
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
