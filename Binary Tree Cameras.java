class Solution {
    int res=0;
    public int minCameraCover(TreeNode root) {
        return fun(root)==0?1+res:res;
    }
    private int fun(TreeNode root){
        if(root==null) return 2;
        int left=fun(root.left);
        int right=fun(root.right);
        if(left==0 || right==0){
            res++;
            return 1;
        }
        if(left==1 || right==1) return 2;
        return 0;
    }
}
