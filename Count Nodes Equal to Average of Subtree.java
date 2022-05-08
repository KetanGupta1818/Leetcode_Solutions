class Solution {
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        fun(root);
        return count;
    }
    //sum n
    private int[] fun(TreeNode root){
        if(root==null) return new int[]{0,0};
        int[] cur = {root.val,1};
        int[] left_arr = fun(root.left);
        int[] right_arr = fun(root.right);
        cur[0] += left_arr[0] + right_arr[0];
        cur[1] += left_arr[1] + right_arr[1];
        if(cur[1]!=0) if(cur[0]/cur[1] == root.val) count++;
        return cur;
    }
}
