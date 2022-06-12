class Solution {
    int min = Integer.MAX_VALUE;
    public int distributeCookies(int[] cook, int k) {
        fun(cook,0,new int[k]);
        return min;
    }
    private void fun(int[] cook, int index, int[] children){
        if(index==cook.length){
            int max = -1;
            for(int child: children) max = Math.max(max,child);
            min = Math.min(min,max);
            return;
        }
        for(int c=0;c<children.length;c++){
            children[c]+=cook[index];
            fun(cook,index+1,children);
            children[c] -= cook[index];
        }
    }
}
