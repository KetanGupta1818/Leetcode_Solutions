class Solution {
    List<Integer> list = new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        TreeNode root1 = new TreeNode(-1);
        TreeNode temp = root1;
        for(int val: list){
            TreeNode node = new TreeNode(val);
            temp.right = node;
            temp = temp.right;
        }
        return root1.right;
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
