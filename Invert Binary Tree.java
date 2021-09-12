class Solution {
    public TreeNode invertTree(TreeNode root) {
        TreeNode temp = new TreeNode();
        if(root == null) return root;
        else{
            temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
        
    }
}
