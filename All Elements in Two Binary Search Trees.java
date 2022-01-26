class Solution {
    List<Integer> list;
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        list = new ArrayList<>();
        if(root1!=null) inorder(root1);
        if(root2!=null) inorder(root2);
        Collections.sort(list);
        return list;
    }
    public void inorder(TreeNode root){
        if(root.left!=null) inorder(root.left);
        list.add(root.val);
        if(root.right!=null) inorder(root.right);
    }
}
