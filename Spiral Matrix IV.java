class Solution {
    public int[][] spiralMatrix(int rows, int cols, ListNode head) {
        int[][] ans = new int[rows][cols];
        int filled = 0,lap=0;
        while(filled < rows*cols){
            for(int c=lap;c<cols-lap;c++){
                ++filled;
                ans[lap][c] = (head ==  null) ? -1 : head.val;
                if(head!=null) head = head.next;
            }
            if(filled>=rows*cols) break;
            for(int r=lap+1;r<rows-lap;r++){
                ++filled;
                ans[r][cols-lap-1] = (head ==  null) ? -1 : head.val;
                if(head!=null) head = head.next;
            }
            if(filled>=rows*cols) break;
            for(int c=cols-lap-2;c>=lap;c--){
                ++filled;
                ans[rows-lap-1][c] = (head ==  null) ? -1 : head.val;
                if(head!=null) head = head.next;
            }
            if(filled>=rows*cols) break;
            for(int r=rows-lap-2;r>lap;r--){
                ++filled;
                ans[r][lap] = (head ==  null) ? -1 : head.val;
                if(head!=null) head = head.next;
            }
            lap++;
        }
        return ans;
    }
}
