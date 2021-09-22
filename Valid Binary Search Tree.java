class Solution {
    public boolean isValidBST(TreeNode root) {
        double dmax = 2147483648d;
        double dmin = -2147483649d;
        return isBST(root, dmin, dmax);
    }
    public boolean isBST(TreeNode root, double min, double max){
        if(root==null) return true;
        return root.val>min && root.val<max && isBST(root.left,min,(double)root.val) && isBST(root.right,(double)root.val,max);
    }
}
