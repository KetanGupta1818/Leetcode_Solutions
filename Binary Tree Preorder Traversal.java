class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> temp_list = new ArrayList<>();
        if(root==null) return temp_list;
        temp_list.add(root.val);
        temp_list.addAll(preorderTraversal(root.left));
        temp_list.addAll(preorderTraversal(root.right));
        return temp_list;
    }
}
