class Solution {
    public int countNodes(TreeNode root) {
        if(fun1(root)==fun2(root)) return (1<<(fun1(root)))-1;
        return countNodes(root.left)+countNodes(root.right)+1;
    }
    private int fun1(TreeNode root){
        if(root == null) return 0;
        return fun1(root.left)+1;
    }
    private int fun2(TreeNode root){
        if(root == null) return 0;
        return fun2(root.right)+1;
    }
}
