class Solution {
    int index;
    public TreeNode bstFromPreorder(int[] preorder) {
        index = 0;
        return formBST(preorder,Integer.MAX_VALUE);
    }
    public TreeNode formBST(int[] preorder, int max){
        if(index==preorder.length || preorder[index]>max) return null;
        TreeNode root = new TreeNode(preorder[index++]);
        root.left = formBST(preorder,root.val);
        root.right = formBST(preorder,max);
        return root;
    }
}
