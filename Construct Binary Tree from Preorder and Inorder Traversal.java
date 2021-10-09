class Solution {
    int preorderIndex;
    HashMap<Integer,Integer> inorderIndex; 
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderIndex = new HashMap<Integer, Integer>();
        for(int i=0;i<inorder.length;i++){
            inorderIndex.put(inorder[i],i);
        }
        return arrayToTree(preorder,0,preorder.length-1);
    }
    public TreeNode arrayToTree(int[] preorder, int left, int right){
        if(left>right) return null;
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);
        root.left = arrayToTree(preorder, left,inorderIndex.get(rootValue)-1);
        root.right = arrayToTree(preorder, inorderIndex.get(rootValue)+1,right);
        return root;
    }
}
