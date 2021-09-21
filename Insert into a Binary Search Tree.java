class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            TreeNode temp = new TreeNode(val);
            return temp;
        }
        if(root.val>val) root.left = insertIntoBST(root.left,val);
        else root.right = insertIntoBST(root.right,val);
        return root;
    }
}
