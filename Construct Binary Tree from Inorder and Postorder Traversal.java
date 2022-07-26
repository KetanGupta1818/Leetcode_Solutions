class Solution {
    public TreeNode buildTree(int[] in, int[] po) {
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        for(int i=0;i<in.length;i++){
            inorder.add(in[i]);
            postorder.add(po[i]);
        }
        return fun(inorder,postorder);
    }
    private TreeNode fun(List<Integer> inorder, List<Integer> postorder){
        int size = inorder.size();
        if(size == 0) return null;
        int val = postorder.get(size-1);
        TreeNode root = new TreeNode(val);
        if(size == 1) return root;
        int index = inorder.indexOf(val);
        root.left = fun(inorder.subList(0,index),postorder.subList(0,index));
        root.right = fun(inorder.subList(index+1,size),postorder.subList(index,size-1));
        return root;
    }
}
