class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        else if(root.val>key) root.left = deleteNode(root.left,key);
        else if(root.val<key) root.right = deleteNode(root.right,key);
        else{
            if(root.left==null && root.right==null) return null;
            else if(root.right!=null){
                root.val = successor(root);
                root.right = deleteNode(root.right,root.val);
            }
            else{   //root.right==null and root.left!=null
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
    public int successor(TreeNode root){
        root=root.right;
        while(root.left!=null) root=root.left;
        return root.val;
    } 
    public int predecessor(TreeNode root){
        root=root.left;
        while(root.right!=null) root=root.right;
        return root.val;
    }
}
