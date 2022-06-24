class Solution {
    Map<TreeNode,Integer> dp1 = new HashMap<>();
    Map<TreeNode,Integer> dp2 = new HashMap<>();
    public int rob(TreeNode root) {
        dp1.put(null,0);
        dp2.put(null,0);
        fun(root);
        return Math.max(dp1.get(root),dp2.get(root));
    }
    private void fun(TreeNode root){
        if(root == null) return;
        fun(root.left);
        fun(root.right);
        dp1.put(root,dp2.get(root.left) + dp2.get(root.right) + root.val);
        dp2.put(root,Math.max(dp2.get(root.left),dp1.get(root.left))+Math.max(dp2.get(root.right),dp1.get(root.right)));
    }
}
