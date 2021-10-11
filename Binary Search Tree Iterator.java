class BSTIterator {
    List<Integer> list;
    int index;
    public BSTIterator(TreeNode root) {
        this.list = new ArrayList<>();
        inorder(root);
        this.index = -1;
        System.out.println(list);
    }
    
    public int next() {
        index++;
        return list.get(index);
        
    }
    
    public boolean hasNext() {
        if(index>=list.size()-1) return false;
        else return true;
        
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
