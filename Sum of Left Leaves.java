class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null || isLeaf(root)) return 0;
        int sum = 0;
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        while(!Q.isEmpty()){
            TreeNode temp = Q.remove();
            if(temp.left!=null && isLeaf(temp.left)) sum += temp.left.val;
            if(temp.left!=null) Q.add(temp.left);
            if(temp.right!=null) Q.add(temp.right);
        }
        return sum;
    }
    public boolean isLeaf(TreeNode root){
        if(root==null) return false;
        if(root.left == null && root.right==null) return true;
        else return false;
    }
}
