class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null) return null;
        TreeNode newNode = new TreeNode();
        if(root1==null) return root2;
        else if(root2==null) return root1;
        else{
            newNode.val = root1.val+root2.val;
            newNode.left = mergeTrees(root1.left,root2.left);
            newNode.right = mergeTrees(root1.right,root2.right);
        }
        return newNode;
    }
}
