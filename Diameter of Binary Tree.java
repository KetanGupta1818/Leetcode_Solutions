class Solution {
    int prevMax = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return prevMax;
    }
    public int helper(TreeNode root){
        if(root==null) return 0;
        int leftValue = helper(root.left);
        int rightValue = helper(root.right);
        if(rightValue+leftValue>prevMax) prevMax=rightValue+leftValue;
        return Math.max(rightValue,leftValue)+1;
    }
}

