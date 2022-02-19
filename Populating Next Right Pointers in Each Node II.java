class Solution {
    public Node connect(Node root) {
        if(root==null) return null;
        if(root.left==null && root.right==null) return root;
        if(root.right==null){
            root.left.next = nextChild(root.next);
        }
        else if(root.left==null) root.right.next = nextChild(root.next);
        else{
            root.left.next = root.right;
            root.right.next = nextChild(root.next);
        }
        connect(root.right);
        connect(root.left);
        
        return root;
    }
    public Node nextChild(Node root){
        if(root == null) return null;
        if(root.left==null && root.right==null) return nextChild(root.next);
        if(root.left == null) return root.right;
        return root.left;
    }
}
