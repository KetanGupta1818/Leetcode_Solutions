class Solution {
    public int minimumRecolors(String blocks, int k) {
        int min = 1000;
        for(int i=0;i<blocks.length()-k+1;i++) min=Math.min(min,fun(blocks,k,i));
        return min;
    }
    private int fun(String s, int k,int index){
        int count = 0;
        for(int i=index;i<index+k;i++) if(s.charAt(i)=='W') count++;
        return count++;
    }
}
