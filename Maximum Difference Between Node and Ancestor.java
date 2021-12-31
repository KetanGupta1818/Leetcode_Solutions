class Solution {
    int result = 0;
    public int maxAncestorDiff(TreeNode root) {
        if(root==null) return -1;
        helper(root,root.val,root.val);
        return result;
    }
    public void helper(TreeNode root, int curMax,int curMin){
        if(root==null) return;
        result = Math.max(result,(Math.max(Math.abs(root.val-curMax),Math.abs(root.val-curMin))));
        helper(root.left,Math.max(curMax,root.val),Math.min(curMin,root.val));
        helper(root.right,Math.max(curMax,root.val),Math.min(curMin,root.val));
    }
}
