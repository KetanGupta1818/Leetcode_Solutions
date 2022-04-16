class Solution {
    int totalSum;
    public TreeNode convertBST(TreeNode root) {
        totalSum = getSum(root);
        inorder(root);
        return root;
    }
    public int getSum(TreeNode root){
        if(root==null) return 0;
        return root.val + getSum(root.left) + getSum(root.right);
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        int temp = root.val;
        root.val = totalSum;
        totalSum -= temp;
        inorder(root.right);
    }
}
//Solution 2
class Solution {
    int totalSum = 0;
    public TreeNode convertBST(TreeNode root) {
        inorder(root);
        return root;
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.right);
        totalSum+=root.val;
        root.val=totalSum;
        inorder(root.left);
    }
}
