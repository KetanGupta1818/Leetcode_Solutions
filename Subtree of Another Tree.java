class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) return false;
        return isSame(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    public boolean isSame(TreeNode r1, TreeNode r2){
        if(r1==null && r2==null) return true;
        if(r1==null || r2==null) return false;
        return r1.val==r2.val && isSame(r1.left,r2.left) && isSame(r1.right,r2.right);
    }
}
