class Solution {
    int sum = 0;
    public int findTilt(TreeNode root) {
        helper(root);
        return sum;
    }
    public int helper(TreeNode root){
        if(root == null) return 0;
        int leftSum = helper(root.left);
        int rightSum = helper(root.right);
        if(rightSum>leftSum) sum = sum + rightSum - leftSum;
        else sum = sum + leftSum - rightSum;
        return root.val+leftSum+rightSum;
    }
}
