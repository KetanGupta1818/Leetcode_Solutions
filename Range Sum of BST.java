class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        if(root==null) return sum;
        if(root.val>high) sum = sum + rangeSumBST(root.left,low,high);
        else if(root.val<low) sum = sum + rangeSumBST(root.right,low,high);
        else sum = sum + root.val + rangeSumBST(root.right,low,high) + rangeSumBST(root.left,low,high);
        return sum;
    }
}
