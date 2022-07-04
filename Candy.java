class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if(n == 1) return 1;
        Queue<int[]> queue = new PriorityQueue<>((a,b)->(a[0]==b[0])?a[1]-b[1]:a[0]-b[0]);
        for(int i=0;i<n;i++) queue.offer(new int[]{ratings[i],i});
        int[] candies = new int[n];
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int rating = cur[0];
            int index = cur[1];
            if(index == 0) {
                candies[0] = candies[1]+1;
                continue;
            }
            if(ratings[index-1] == ratings[index]) {
                if(index == n-1) candies[index] = 1;
                else candies[index] = candies[index+1] + 1;
            }
            else{
                if(index == n-1) candies[index] = candies[index-1]+1;
                else candies[index] = Math.max(candies[index-1],candies[index+1])+1;
            }
        }
        int sum = 0;
        for(int c: candies) sum += c;
        return sum;
    }
}
