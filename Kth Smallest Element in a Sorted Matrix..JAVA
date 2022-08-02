class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        Queue<Point> queue = new PriorityQueue<>((p1,p2)->p1.value-p2.value);
        queue.offer(new Point(0,0,matrix[0][0]));
        int answer = 0;
        while(k-->0){
            Point p = queue.remove();
            
            answer = p.value;
            if(p.x < n-1 && matrix[p.x+1][p.y]!=Integer.MAX_VALUE) {
                queue.offer(new Point(p.x+1,p.y,matrix[p.x+1][p.y]));
                matrix[p.x+1][p.y]=Integer.MAX_VALUE;
            }
            if(p.y < n-1 && matrix[p.x][p.y+1]!=Integer.MAX_VALUE) {
                queue.offer(new Point(p.x,p.y+1,matrix[p.x][p.y+1]));
                matrix[p.x][p.y+1]=Integer.MAX_VALUE;
            }
        }
        return answer;
    }
}
class Point{
    int x;
    int y;
    int value;
    
    public Point(int x, int y, int value){
        this.x = x;
        this.y = y;
        this.value = value;
    }
}
