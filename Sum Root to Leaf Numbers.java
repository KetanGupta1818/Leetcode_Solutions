class Solution {
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        return helper(root,root.val);
    }
    public int helper(TreeNode root, int sum){
        if(root.left==null && root.right==null) return sum;
        if(root.left==null) return helper(root.right,sum*10+root.right.val);
        if(root.right==null) return helper(root.left,sum*10+root.left.val);
        return helper(root.right,sum*10+root.right.val)+helper(root.left,sum*10+root.left.val);
    }
}
